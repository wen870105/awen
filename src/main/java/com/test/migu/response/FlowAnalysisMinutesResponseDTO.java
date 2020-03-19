package com.test.migu.response;

/**
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class FlowAnalysisMinutesResponseDTO  {
	/**
	 * 时段, 6:00-12:00
	 */
	private String section;

	/**
	 * 请求ip
	 */
	private String reqIp;

	/**
	 * 访问量
	 */
	private String reqTotal;

	/**
	 * 触碰规则数
	 */
	private String hitRules;

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getReqIp() {
		return reqIp;
	}

	public void setReqIp(String reqIp) {
		this.reqIp = reqIp;
	}

	public String getReqTotal() {
		return reqTotal;
	}

	public void setReqTotal(String reqTotal) {
		this.reqTotal = reqTotal;
	}

	public String getHitRules() {
		return hitRules;
	}

	public void setHitRules(String hitRules) {
		this.hitRules = hitRules;
	}

}
