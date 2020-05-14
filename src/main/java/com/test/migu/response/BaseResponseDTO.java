package com.test.migu.response;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class BaseResponseDTO {

	/**
	 * 消息代码，查询失败时，返回定义的错误码，成功为空字符串
	 */
	private String code;
	/**
	 * 消息内容，查询失败时，返回错误描述，成功为空字符串
	 */
	private String msg;

	/** 全链路上下文id */
	private String traceId;

	/**
	 * 
	 */
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}