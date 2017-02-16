package com.wen.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Author: Wen
 * @CreatDate: 2015年9月21日
 * @Version:
 */
public class StringToMap {
	
	/**
	 * 字符串转为MAP,key value使用"="分割
	 * @param keyAndVals
	 * @return
	 */
	public static Map<String,String> convert(String... keyAndVals){
		if(keyAndVals == null){
			return null;
		}
		
		Map<String,String> map = new HashMap<String, String>();
		for(String kv : keyAndVals){
			if(kv.indexOf("=")>=0){
				String[] ret = kv.split("="); 
				map.put(ret[0], ret[1]);
			}
		}
		return map;
	}
	
	/**
	 * 返回key是Integer的map
	 * @param keyAndVals
	 * @return
	 */
	public static Map<Integer,String> convertIntegerOfKeyMap(String... keyAndVals){
		if(keyAndVals == null){
			return null;
		}
		
		Map<Integer,String> map = new HashMap<Integer, String>();
		for(String kv : keyAndVals){
			if(kv.indexOf("=")>=0){
				String[] ret = kv.split("="); 
				map.put(Integer.valueOf(ret[0]), ret[1]);
			}
		}
		return map;
	}
}
