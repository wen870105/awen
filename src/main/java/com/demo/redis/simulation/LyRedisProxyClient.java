package com.demo.redis.simulation;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

public class LyRedisProxyClient {
	private static final String PROXY_IP = "127.0.0.1";

	public static void main(String[] args) {
		jedis();
	}

	public static void jedis() {

		Jedis j = new Jedis(PROXY_IP, 9999);
		for (int i = 0; i < 10; i++) {
			String ret = j.set("k1_" + i, "val_" + i);
			j.close();
			System.out.println("resp:" + ret);
			j = new Jedis(PROXY_IP, 9999);
		}
	}

}
