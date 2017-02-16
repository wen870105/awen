package com.wen.domain;

import java.util.Date;

import com.wen.domain.base.BaseDomain;

/**
 * 
 * @author Wen
 * @since 2017-01-18
 */
public class ExportWen extends BaseDomain{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8788031493478728152L;
	// 
	private Date createTime;
	// 
	private String recordUrl;
	// 
	private Long id;

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setRecordUrl(String recordUrl) {
		this.recordUrl = recordUrl;
	}

	public String getRecordUrl() {
		return recordUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}