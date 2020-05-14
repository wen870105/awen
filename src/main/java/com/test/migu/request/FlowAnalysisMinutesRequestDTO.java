package com.test.migu.request;

/**
 * .
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class FlowAnalysisMinutesRequestDTO extends BaseRequestDTO {
	/**
	 * 域www.xxx.com
	 */
	private String domain;
	/**
	 * 入口/entry
	 */
	private String entry;
	/**
	 * 查询日期，格式为 yyyy-MM-dd
	 */
	private String queryDate;
	/**
	 * 起始时间,格式为HH:mm
	 */
	private String fromTime;
	/**
	 * 结束时间,格式为HH:mm
	 */
	private String toTime;

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
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

}
