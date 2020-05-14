package com.test.migu.request;

import java.util.List;

/**
 * 业务分析
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class BizAnalysisRequestDTO extends BaseRequestDTO {
	/**
	 * 查询条件,类似sql查询
	 */
	private String query;
	/**
	 * 查询类型,目前只有detail,group两个值
	 */
	private List<String> columns;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

}
