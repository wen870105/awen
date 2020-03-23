package com.test.migu.response;

import java.util.List;

/**
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class SerieDTO {
	/**
	 * 线名称
	 */
	private String name;
	/**
	 * 图标数值
	 */
	private List<String> data;

	public SerieDTO() {
	}

	public SerieDTO(List<String> data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
}
