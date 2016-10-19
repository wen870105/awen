package com.wen.util;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * @author Wen
 * @CreatDate: 2016年5月23日
 */
public class StringFormat {

	/**
	 * e.g.:"a {key1} is b" , map={"key1","haha" }
	 * return a haha is b
	 * @param str
	 * @param map
	 * @return
	 */
	public static String format(String str, Map<String, String> map) {
		if (map != null) {
			String ret = str;
			for (Map.Entry<String, String> en : map.entrySet()) {
				String key = "{" + en.getKey() + "}";
				if (str.contains(key)) {
					ret = str.replace(key, en.getValue());
				}
			}
			return ret;
		}
		return str;
	}

	public static String format(String str, Object obj) {
		try {
			Map<String, String> map = BeanUtils.describe(obj);
			return format(str, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
