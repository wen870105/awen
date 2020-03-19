package com.demo.redis.simulation;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class LyRedisProxyServer {
	private static List<String> servers = new ArrayList(5);
	static {
		servers.add("127.0.0.1:6380");
		servers.add("127.0.0.1:6381");
		servers.add("127.0.0.1:6379");
	}

	public static void main(String[] args) throws Exception {

		int port = 9999;
		System.out.println("代理服务器端口号:" + port + "__" + servers.size());

		ServerSocket server = new ServerSocket(port);

		Socket socket;
		int i = 0;
		while ((socket = server.accept()) != null) {
			try {
				while (true) {
					System.out.println("来请求了...");
					InputStream is = socket.getInputStream();
					byte[] request = new byte[1024];
					is.read(request);
					String reqStr = new String(request);
					System.out.println("请求内容为:" + reqStr);

					i++;
					int mod = i % 3;
					System.out.println(mod);
					String endpoint = servers.get(mod);
					System.out.println("取模选取服务器:" + endpoint);
					String[] arr = endpoint.split(":");
					Socket client = new Socket(arr[0], Integer.parseInt(arr[1]));
					client.getOutputStream().write(request);

					byte[] resp = new byte[1024];
					client.getInputStream().read(resp);
					client.close();

					socket.getOutputStream().write(resp);
					System.out.println("请求完成.");
				}
			} catch (Exception e) {
//				e.printStackTrace();
			}

		}

	}
}
