/*
 * Copyright (c) 2017-06-26 com.wen All rights reserved.
 * 本软件源代码版权归----所有,未经许可不得任意复制与传播.
 * 2017-06-26 生成于wCodeMaker wnick123@gmail.com
 */
package com.wen.domain;

import com.wen.domain.base.BaseDomain;

/**
 * 
 * @author Wen
 * @since 2017-06-26
 */
public class UserTest extends BaseDomain{
	// e
	private Long id;
	// name22222
	private String name;
	// pwd11111
	private String pwd;
	// phone
	private Integer phone;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getPhone() {
		return phone;
	}
}