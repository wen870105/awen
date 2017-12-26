/*
 * Copyright (c) 2017-06-26 com.wen All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 * 2017-06-26 生成于wCodeMaker wnick123@gmail.com
 */
package com.wen.domain.base;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @author Wen
 *
 * @CreateDate 2017年1月4日
 */
public class BaseDomain extends QueryCondition {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4597554221498486920L;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
