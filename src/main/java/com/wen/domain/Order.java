package com.wen.domain;

import java.util.Date;

/**
 * 
 * @author Wen
 * @since 2016-05-09
 */
public class Order {
	// 
	private Long id;
	// 
	
	private String name;
	// 
	private Date createDate;

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

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}
}