package com.test.colloect;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T {
	public static void main(String[] args) {
//		LinkedHashMap
//			ConcurrentHashMap<K, V>
		final HashMap<String, String> map = new HashMap<String, String>();
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(9);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					map.put(Thread.currentThread().getName(), new Random().nextInt() + "");
				}
			});
		}
		for (String k : map.keySet()) {
			System.out.println(k);
		}

	}
}
