package com.test.migu.request;

/**
 * .
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class FlowAnalysisDateRequestDTO extends BaseRequestDTO {
	
	/**
	 * 查询起始日期，格式为 yyyy-MM-dd
	 */
	private String fromDate;
	
	/**
	 * 查询结束日期，格式为 yyyy-MM-dd（和fromDate同时不为空或者为空,系统默认时间为最近一周）
	 */
	private String toDate;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
