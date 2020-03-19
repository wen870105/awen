package com.test.migu.response;

import java.util.List;

/**
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class FlowAnalysisDateResponseDTO {
	/**
	 * 列信息,日期维度
	 */
	private List<String> columns;
	/**
	 * 具体数值
	 */
	private List<String> valList;

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public List<String> getValList() {
		return valList;
	}

	public void setValList(List<String> valList) {
		this.valList = valList;
	}

}
