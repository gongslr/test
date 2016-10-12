package com.jt.benchmark.redistest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSeparatorUI;

import redis.clients.jedis.Jedis;

public class RedisExample {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		//不使用连接池
		// 初始化
		Jedis jedis = new Jedis("10.47.184.202", 6379);

		// 设置密码
		jedis.auth("redis");
		
		
		

		// 传入单键值
		/*jedis.set("name", "aaaa");
		System.out.println("String name: " + jedis.get("name"));

		// 传入多键值
		jedis.mset("name", "steve", "age", "23", "sex", "man", "tel",
				"12345678901"); // name会覆盖之前的值
		System.out.println("Map name: " + jedis.mget("name") + " ---- Map age:"
				+ jedis.mget("age"));*/

		// 传入HashMap
		Map connector_A = new HashMap();
		connector_A.put("address", "http://10.47.184.206:8080/hello.jsp");
		connector_A.put("username", "username");
		connector_A.put("password", "password");
		connector_A.put("strategy", "0"); //0:Single 1:RR
		connector_A.put("status", "0");  //0:正常 1:高负载 2:异常
		

		jedis.hmset("connector_A", connector_A);
		
		
		List<String> addresses = new ArrayList<String>();
		
		
		Map connector_B = new HashMap();
		connector_B.put("address", "http://10.47.184.208:8080/hello.jsp");
		connector_B.put("username", "username");
		connector_B.put("password", "password");
		connector_B.put("status", "0");

		jedis.hmset("connector_B", connector_B);
		
		
		Map connector_C = new HashMap();
		connector_C.put("address", "http://10.47.184.209:8080/hello.jsp");
		connector_C.put("username", "username");
		connector_C.put("password", "password");
		connector_C.put("status", "0");

		jedis.hmset("connector_C", connector_C);
		
		Map connector_D = new HashMap();
		connector_D.put("address", "http://10.47.184.210:8080/hello.jsp");
		connector_D.put("username", "username");
		connector_D.put("password", "password");
		connector_D.put("status", "0");

		jedis.hmset("connector_D", connector_D);
		
		/*System.out.println("Map user(name, local) is: "
				+ jedis.hmget("user", "name", "local"));
		System.out.println("Map user(length) is: " + jedis.hlen("user"));
		System.out.println("Map user if exists: " + jedis.exists("user"));
		System.out.println("Map user's keys are: " + jedis.hkeys("user"));
		System.out.println("Map user's values are: " + jedis.hvals("user"));*/

		// 传入List，如果有多个 value值，那么各个 value值按从上到下（从左到右）的顺序依次插入到表头

		/*jedis.lpush("city", "beijing");
		jedis.lpush("city", "shanghai");
		jedis.lpush("city", "wuhan", "guangzhou");
		System.out.println("List city is: " + jedis.lrange("city", 0, 2)); // 输出的顺序与输入正好相反

		// 删除key
		jedis.del("city");*/

		// List可以有重复
		List<String> city = new ArrayList<String>();
		/*city.add("beijing");
		city.add("shanghai");
		city.add("wuhan");
		city.add("guangzhou");
		city.add("shanghai");
		for (String string : city) {
			jedis.lpush("city", string);
		}
		System.out.println("List city is: " + jedis.lrange("city", 0, -1)); // -1代表打印list中所有的值
		jedis.del("city");*/

		
		//传入Set
		/*jedis.sadd("int", "100");
		jedis.sadd("int", "200");
		jedis.sadd("int", "300");
		jedis.sadd("int", "100");
		jedis.sadd("int", "300");
		System.out.println("Set int has: " + jedis.smembers("int"));*/
		
	}

	
}
