package com.test.migu.response;

import java.util.List;

/**
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class BizAnalysisGroupResponseDTO{
	/**
	 * 字段列表,来自入参数据
	 */
	private List<String> columns;
	/**
	 * 字段列表对应的值
	 */
	private List<List<String>> valList;

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public List<List<String>> getValList() {
		return valList;
	}

	public void setValList(List<List<String>> valList) {
		this.valList = valList;
	}

}
