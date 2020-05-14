package com.test.migu.request;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class BaseRequestDTO {

	/** 全链路上下文id */
	@NotEmpty
	private String traceId;

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

}