package com.test.migu.response;

/**
 * 数据类
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class EntryDTO {
	/**
	 * 类型,表示某省,动态扫描等
	 */
	private String type;
	/**
	 * 类型名称
	 */
	private String name;
	/**
	 * 数值
	 */
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
