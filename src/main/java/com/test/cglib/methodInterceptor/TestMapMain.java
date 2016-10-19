package com.test.cglib.methodInterceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestMapMain {
	public static void main(String[] args) {
		Map<String, String> tm = new TreeMap<String, String>();
		Map<String, String> hm = new HashMap<String, String>();
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		chm.put("bbb", "vbbbb");
		chm.put("bbb1", "vbbbb");
		chm.get("bbb");
		
		
		build(tm);
		build(hm);
		
		tm.get("a");
		hm.get("a");
		print(tm);
		print(hm);
	}
	
	private static void print(Map<String, String> map ){
		for(Map.Entry<String, String> en : map.entrySet()){
			System.out.println(en.getKey() + "__" + en.getValue());
		}
	}
	
	private static void build(Map<String, String> map ){
		map.put("a", "va");		
		map.put("c", "vc");
		map.put("b", "vb");
		map.put("d", "vd");
		map.put("e", "ve");
	}
}
