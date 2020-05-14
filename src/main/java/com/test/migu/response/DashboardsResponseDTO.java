package com.test.migu.response;

import java.util.List;

/**
 * 概述
 * @author wen
 * @date 2020年3月19日
 */
public class DashboardsResponseDTO {
	/**
	 * 总请求
	 */
	private Integer totalReq;

	/**
	 * 正常请求
	 */
	private Integer normalReq;

	/**
	 * 异常请求
	 */
	private Integer exceptionReq;

	/**
	 * 白名单请求
	 */
	private Integer whiteListReq;

	/**
	 * 区域列表
	 */
	private List<EntryDTO> regionReqList;

	/**
	 * 异常类型占比
	 */
	private List<EntryDTO> exceptionPercent;

	/**
	 * 自动化工具占比
	 */
	private List<EntryDTO> toolsPercent;

	public Integer getTotalReq() {
		return totalReq;
	}

	public void setTotalReq(Integer totalReq) {
		this.totalReq = totalReq;
	}

	public Integer getNormalReq() {
		return normalReq;
	}

	public void setNormalReq(Integer normalReq) {
		this.normalReq = normalReq;
	}

	public Integer getExceptionReq() {
		return exceptionReq;
	}

	public void setExceptionReq(Integer exceptionReq) {
		this.exceptionReq = exceptionReq;
	}

	public Integer getWhiteListReq() {
		return whiteListReq;
	}

	public void setWhiteListReq(Integer whiteListReq) {
		this.whiteListReq = whiteListReq;
	}

	public List<EntryDTO> getRegionReqList() {
		return regionReqList;
	}

	public void setRegionReqList(List<EntryDTO> regionReqList) {
		this.regionReqList = regionReqList;
	}

	public List<EntryDTO> getExceptionPercent() {
		return exceptionPercent;
	}

	public void setExceptionPercent(List<EntryDTO> exceptionPercent) {
		this.exceptionPercent = exceptionPercent;
	}

	public List<EntryDTO> getToolsPercent() {
		return toolsPercent;
	}

	public void setToolsPercent(List<EntryDTO> toolsPercent) {
		this.toolsPercent = toolsPercent;
	}

}
