package com.demo.redis;

import redis.clients.jedis.Jedis;

public class RedisClient {
	private static final String IP = "127.0.0.1";

	public static void main(String[] args) {
		jedis();
	}

	public static void jedis() {

		Jedis j = new Jedis(IP, 6378);

		j.set("key1", "value");
		
//		j.hset("map", "key1", "v1");
//		j.hset("map", "key2", "v2");
		// System.out.println(j.get("key1"));

		// j.close();

	}
}
