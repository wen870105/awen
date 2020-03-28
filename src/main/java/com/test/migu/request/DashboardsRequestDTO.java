package com.test.migu.request;

import java.util.Date;

/**
 * 概述
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class DashboardsRequestDTO extends BaseRequestDTO {
	/**
	 * 查询起始日期，格式为 yyyy-MM-dd
	 */
	private String fromDate;
	/**
	 * 查询结束日期，格式为 yyyy-MM-dd（和fromDate同时不为空或者为空,系统默认时间为最近一周）
	 */
	private Date toDate;

	/**
	 * 域
	 */
	private String domain;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
