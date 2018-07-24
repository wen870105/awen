package com.demo.redis;

import redis.clients.jedis.Jedis;

public class RedisClient {
	private static final String IP = "127.0.0.1";

	public static void main(String[] args) {
		jedis();
	}

	public static void jedis() {

		Jedis j = new Jedis(IP, 6379);

		j.set("key122222e", "value");
//		hmap key_m sk v
//		j.hset("key_m", "sk", "v");
//		j.hset("map", "key2", "v2");
		// System.out.println(j.get("key1"));

		// j.close();

	}
}
