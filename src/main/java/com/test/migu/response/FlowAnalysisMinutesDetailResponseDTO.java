package com.test.migu.response;

import java.util.List;

/**
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class FlowAnalysisMinutesDetailResponseDTO {
	/**
	 * 请求ip
	 */
	private String reqIp;

	/**
	 * 路径
	 */
	private String path;

	/**
	 * 浏览器信息
	 */
	private String userAgent;

	/**
	 * canvasId
	 */
	private String canvasId;

	/**
	 * 区域
	 */
	private String region;

	/**
	 * 访问时间,格式yyyy-MM-DD HH:mm:ss
	 */
	private String accessDate;

	public String getReqIp() {
		return reqIp;
	}

	public void setReqIp(String reqIp) {
		this.reqIp = reqIp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getCanvasId() {
		return canvasId;
	}

	public void setCanvasId(String canvasId) {
		this.canvasId = canvasId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(String accessDate) {
		this.accessDate = accessDate;
	}
}
