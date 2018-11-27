package com.demo.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisClient {
	private static final String IP = "127.0.0.1";

	public static void main(String[] args) {
		jedis();
	}

	public static void jedis() {

		Jedis j = new Jedis(IP, 6379);

		j.set("key122222e", "value");
		
		j.lpush("keyList", "1");
		j.lpush("keyList", "2");
		j.lpush("keyList", "3");
		j.lpush("keyList", "4");
	List<String> lrange = j.lrange("keyList", 0, 2);
		System.out.println(lrange);
//		hmap key_m sk v
//		j.hset("key_m", "sk", "v");
//		j.hset("map", "key2", "v2");
		// System.out.println(j.get("key1"));

		// j.close();

	}
}
