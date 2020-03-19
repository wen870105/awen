package com.demo.redis.simulation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class LyRedisClient {
	private InputStream inputStream;

	private OutputStream outputStream;

	public LyRedisClient() throws Exception {
		Socket socket = new Socket("127.0.0.1", 6379);
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
	}

	public static void main(String[] args) throws Exception {
		LyRedisClient client = new LyRedisClient();
		String ret = client.set("test", "hahah");
		String ret2 = client.get("test");
		
		System.out.println(ret2);
	}

	public String set(String key, String value) throws Exception {
		// j.set("key1", "value");
		// *3
		// $3
		// SET
		// $4
		// key1
		// $5
		// value

		StringBuffer sb = new StringBuffer();
		sb.append("*3").append("\r\n");
		sb.append("$3").append("\r\n");
		sb.append("SET").append("\r\n");
		sb.append("$" + key.getBytes("UTF-8").length).append("\r\n");
		sb.append(key).append("\r\n");
		sb.append("$" + value.getBytes("UTF-8").length).append("\r\n");
		sb.append(value).append("\r\n");

		return sendCommand(sb.toString());
	}
	
	public String get(String key) throws Exception {
		// get key

		StringBuffer sb = new StringBuffer();
		sb.append("*2").append("\r\n");
		sb.append("$3").append("\r\n");
		sb.append("GET").append("\r\n");
		sb.append("$" + key.getBytes("UTF-8").length).append("\r\n");
		sb.append(key).append("\r\n");

		return sendCommand(sb.toString());
	}

	private String sendCommand(String command) throws IOException {
		outputStream.write(command.getBytes());
		byte[] arr = new byte[1024];
		inputStream.read(arr);
		return new String(arr);
	}
}
