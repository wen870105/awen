package com.tcshare.reflect.resourcedemo;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Administrator
 * @email wnick123@gmail.com
 */
public class ResourceManager {
	private static final Logger logger = LoggerFactory.getLogger(ResourceManager.class);
	private static ResourceManager rm = new ResourceManager();
	private Properties pros;
	
	public ResourceManager() {
		pros = new Properties();
		try {
			pros.load(this.getClass().getResourceAsStream("/resource.properties"));
		} catch (Exception e) {
			logger.error("", e);
		}
	}

	public boolean getBoolean(String key) {
		return Boolean.parseBoolean(getString(key));
	}

	/**
	 * 返回数组
	 * 
	 * @return
	 */
	public String[] getArray(String key) {
		String s = pros.getProperty(key);
		return s == null ? null : s.split(",");
	}

	public String getString(String key) {
		return pros.getProperty(key);
	}

	public static ResourceManager getInstance() {
		return rm;
	}
}
