package com.test.migu.request;

import java.util.List;

/**
 * 业务分析字段详情
 * 
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
	 * 分页页码,起始页,默认值都是1
	 */
	private Integer pageIndex = 1;

	/**
	 * 分页大小,默认是20
	 */
	private Integer pageSize = 20;

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

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
