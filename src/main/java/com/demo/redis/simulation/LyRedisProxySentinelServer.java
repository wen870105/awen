package com.demo.redis.simulation;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.propertyeditors.TimeZoneEditor;

import redis.clients.jedis.Jedis;

/**
 * 哨兵模拟
 * 
 * @author wsy48420
 *
 */
public class LyRedisProxySentinelServer {
	private static List<String> badServerList = new ArrayList<>(5);
	private static List<String> slaveServerList = new ArrayList<>(5);

	private static String master = "127.0.0.1:6379";

	static {
		slaveServerList.add("127.0.0.1:6380");
		slaveServerList.add("127.0.0.1:6381");
	}

	public static void main(String[] args) throws Exception {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				checkMaster();

				updateSlaves();

				checkBadServer();

			}
		}, 3000, 3000l);

	}

	private static void checkMaster() {
		String[] endpoint = master.split(":");
		try {
			Jedis j = new Jedis(endpoint[0], Integer.parseInt(endpoint[1]));
			j.ping();
			j.close();
		} catch (Exception e) {
			System.out.println("master:" + master + "down了");
			badServerList.add(master);
			changeMaster();
		}

	}

	private static void changeMaster() {
		Iterator<String> iterator = slaveServerList.iterator();
		while (iterator.hasNext()) {
			String slave = iterator.next();
			String[] endpoint = slave.split(":");
			try {
				Jedis j = new Jedis(endpoint[0], Integer.parseInt(endpoint[1]));
				// 升主
				j.slaveofNoOne();
				j.close();
				master = slave;
				System.out.println("slave服务器:" + slave + "升为master");
				break;
			} catch (Exception e) {
				badServerList.add(slave);
			} finally {
				iterator.remove();
			}
		}

		// 所有slave切换到master
		for (String slave : slaveServerList) {
			String[] endpoint = slave.split(":");
			Jedis j = new Jedis(endpoint[0], Integer.parseInt(endpoint[1]));

			String[] masterEndpoint = master.split(":");
			j.slaveof(masterEndpoint[0], Integer.parseInt(masterEndpoint[1]));
			j.close();
		}

	}

	private static void updateSlaves() {
		try {
			String[] endpoint = master.split(":");
			Jedis j = new Jedis(endpoint[0], Integer.parseInt(endpoint[1]));
			
			String repliations = j.info("replication");
			String[] lines = repliations.split("\r\n");
			int slaveCount = Integer.parseInt(lines[2].split(":")[1]);

			if (slaveCount > 0) {
				List<String> list = new ArrayList<>(5);
				for (int i = 0; i < slaveCount; i++) {
					String port = lines[3 + i].split(",")[1].split("=")[1];
					list.add("127.0.0.1:" + port);
				}
				slaveServerList.clear();
				slaveServerList.addAll(list);
				System.out.println("更新slavelist:"+ slaveServerList);
			}
			j.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新失败");
			// TODO: handle exception
		}
	}

	private static void checkBadServer() {
		Iterator<String> iterator = badServerList.iterator();
		while (iterator.hasNext()) {
			String bad = iterator.next();
			String[] endpoint = bad.split(":");
			try {
				Jedis j = new Jedis(endpoint[0], Integer.parseInt(endpoint[1]));
				j.ping();
				String[] masterEndpoint = master.split(":");
				j.slaveof(masterEndpoint[0], Integer.parseInt(masterEndpoint[1]));
				j.close();

				slaveServerList.add(bad);
				iterator.remove();
				System.out.println(bad + "回复正常,当前master为:" + master);
			} catch (Exception e) {
			}
		}
	}

	private static void open() throws IOException {
		int port = 26379;
		ServerSocket sentinel = new ServerSocket(port);
		System.out.println("启动模拟哨兵端口为:" + port);

		Socket socket;
		int i = 0;
		while ((socket = sentinel.accept()) != null) {
			try {
				while (true) {
					System.out.println("来请求了...");
					InputStream is = socket.getInputStream();
					byte[] request = new byte[1024];
					is.read(request);
					String reqStr = new String(request);
					System.out.println("请求内容为:" + reqStr);
					System.out.println("");

					String[] params = reqStr.split("\r\n");

					if ("get-master-addr-by-name".equals(params[4])) {
						// 响应
						String result = "*2\r\n" + "$9\r\n" + master.split(":")[0] + "\r\n" + "$4\r\n"
								+ master.split(":")[1] + "\r\n";
						socket.getOutputStream().write(result.getBytes());
					}

				}
			} catch (Exception e) {
				// e.printStackTrace();
			}

		}
	}
}
