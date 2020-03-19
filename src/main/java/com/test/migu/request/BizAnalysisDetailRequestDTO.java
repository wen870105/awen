package com.test.migu.request;

import java.util.List;

/**
 * 业务分析字段详情
 * @author wen
 * @date 2020年3月19日
 */
public class BizAnalysisDetailRequestDTO extends BaseRequestDTO {
	/**
	 * 查询条件,类似sql查询
	 */
	private String query;

	/**
	 * 字段列表,当前保存的的字段所有字段,返回参数也会有对应的值用来渲染页面
	 */
	private List<String> columns;

	/**
	 * 查询的列
	 */
	private String queryColumn;

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

	public String getQueryColumn() {
		return queryColumn;
	}

	public void setQueryColumn(String queryColumn) {
		this.queryColumn = queryColumn;
	}

	

}
