package com.demo.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

public class SentinelClient {
	public static void main(String[] args) {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		String masterName = "mymaster";
		Set<String> sentinels = new HashSet<String>();
		sentinels.add("127.0.0.1:26379");
		JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(masterName, sentinels, poolConfig);
		HostAndPort currentHostMaster = jedisSentinelPool.getCurrentHostMaster();
		System.out.println(currentHostMaster.getHost() + "--" + currentHostMaster.getPort());// 获取主节点的信息
		Jedis resource = jedisSentinelPool.getResource();
		resource.set("sentinel", "s1111");
		String value = resource.get("key");
		System.out.println(value);// 获得键a对应的value值
		resource.close();
	}
}
