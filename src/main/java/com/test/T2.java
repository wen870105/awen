package com.test;

import java.util.HashMap;
import java.util.Map;

public class T2 {
	public static void main(String[] args) {
	        System.out.println(Long.toString(System.currentTimeMillis(), 36));
		HashMap<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		for (Map.Entry<String, String> en : map.entrySet()) {
			System.out.println(en.getKey() + "=" + en.getValue());
		}
		System.out.println(map);
	}
}
