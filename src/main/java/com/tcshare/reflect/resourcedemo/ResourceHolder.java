/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.tcshare.reflect.resourcedemo;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author wsy48420
 * @version $Id: ResourceData.java, v 0.1 2018年1月5日 下午3:49:35 wsy48420 Exp $
 */
/**
 * @author wsy48420
 *
 */
public class ResourceHolder {
	private static final Logger logger = LoggerFactory.getLogger(ResourceHolder.class);

	private static ResourceData data;

	public static ResourceData getData() {
		if (data == null) {
			data = getCfgData();
		}
		return data;
	}

	private static ResourceData getCfgData() {
		ResourceManager rm = ResourceManager.getInstance();
		ResourceData data = new ResourceData();
		Field[] fs = ResourceData.class.getDeclaredFields();
		for (Field f : fs) {
			ResAnt ant = f.getAnnotation(ResAnt.class);
			String name = ant == null ? f.getName() : ant.value();
			f.setAccessible(true);
			try {
				f.set(data, rm.getString(name));
			} catch (Exception e) {
				logger.error("", e);
			}
		}
		return data;
	}


}
