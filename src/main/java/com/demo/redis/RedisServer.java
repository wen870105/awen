package com.demo.redis;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RedisServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(6378);
		
		
		while(true){
			Socket socket = server.accept();
			InputStream is = socket.getInputStream();
			
			byte[] arr = new byte[1024];
			is.read(arr);
			String s = new String(arr);	
			System.out.println(s);
		}
		
		
//		server.close();
	}
}
