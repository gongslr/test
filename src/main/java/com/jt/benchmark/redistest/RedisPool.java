package com.jt.benchmark.redistest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
	public static JedisPool pool = null; 
	public static final String HOST = "10.47.184.202";
	public static final int PORT = 6379;
	public static final String PASSWORD = "redis";
	

	public static JedisPool getPool(){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxWaitMillis(2000);
		config.setMaxIdle(5);
		pool = new JedisPool(config, HOST, PORT, 5000, PASSWORD);
		return pool;
	}
	
	/** 
     * 在多线程环境同步初始化 
     */  
    private static synchronized void poolInit() {  
        if (pool == null) {    
        	getPool();  
        }  
    }
	
	public static synchronized Jedis getJedis(){
		if (pool == null) {    
			poolInit();  
        }
		Jedis jedis = null;
		try {    
            if (pool != null) {    
                jedis = pool.getResource();   
            }  
        } catch (Exception e) {    
        	System.out.println("Get jedis error: " + e);
        }finally{  
            closePool(jedis);
        }
		return jedis;
	}
	
	public static void closePool(Jedis jedis){
		if (jedis != null && pool != null){
			pool.returnResource(jedis);
		}
		
	}
}
