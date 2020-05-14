package com.thread.consumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public class Container {
	public static List<String> list = new ArrayList<>();
	private static int i = 0;
	
	public static void add(Object obj) throws InterruptedException {

		String s = (i++) + RandomUtils.nextInt(1, 1000) + "";
		list.add(s);
		System.out.println("producr:" + s);
		synchronized (Container.class) {
			Container.class.notify();
		}

	}

	public static String get(Object obj) {

		if (list.size() == 0) {
			synchronized (Container.class) {
				try {
					Container.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		String s = list.get(0);
		list.remove(0);

		return s;
	}

	public static void main(String[] args) throws IOException {
		Object obj = new Object();
		Producer p = new Producer();
		p.setObj(obj);
		p.start();

		Consumer c = new Consumer();
		c.setObj(obj);
		c.start();
		// try {
		// c.join();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.in.read();
	}
}
