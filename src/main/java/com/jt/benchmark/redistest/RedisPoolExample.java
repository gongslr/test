package com.jt.benchmark.redistest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;




public class RedisPoolExample {
	 //定义连接池
	
	private static Jedis jedis = RedisPool.getJedis();

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	
		testString();
		testMap();
		testList();
		testSet();
	}
	
	
	
	public static void testString(){
		
		jedis.set("name", "redis");
		jedis.mset("host", "jf2", "port", "6379");
		System.out.println("jedisString name is :"+ jedis.get("name") + " host is :"+ jedis.get("host"));
		//输出：jedisString name is :redis host is :jf2
		
	}
	
    public static void testMap(){
		
    	HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "xxxx");
		map.put("age", "100");
		map.put("local", "nanjing");

		jedis.hmset("user", map);
		System.out.println("Map user(name, age, local) : "
				+ jedis.hmget("user", "name", "age", "local"));
		//输出：Map user(name, age, local) : [xxxx, 100, nanjing]
		
	}
    
    public static void testList(){
		
    	List<String> city = new ArrayList<String>();
		city.add("beijing");
		city.add("shanghai");
		city.add("wuhan");
		city.add("guangzhou");
		city.add("shanghai");
		for (String string : city) {
			jedis.lpush("city", string);
		}
		System.out.println("List city is: " + jedis.lrange("city", 0, -1));
		//输出：List city is: [shanghai, guangzhou, wuhan, shanghai, beijing]，**List可以有重复，且反向输出**
		
	}
    
    public static void testSet(){
		
    	jedis.sadd("int", "100");
		jedis.sadd("int", "200");
		jedis.sadd("int", "300");
		jedis.sadd("int", "100");
		jedis.sadd("int", "300");
		System.out.println("Set int is: " + jedis.smembers("int"));
		//输出：Set int is: [100, 200, 300]。**Set会去掉重复**
	}
    
}
