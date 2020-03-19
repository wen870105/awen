package com.test.migu.request;

/**
 * .
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class FlowAnalysisHoursRequestDTO extends BaseRequestDTO {

	/**
	 * 查询维度,小时
	 */
	private String type;
	/**
	 * 域www.xxx.com
	 */
	private String domain;
	/**
	 * 入口/entry
	 */
	private String entry;
	
	/**
	 * 日期 yyyy-MM-dd
	 * @return
	 */
	private String queryDate;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

}
