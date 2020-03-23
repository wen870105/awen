package com.test.migu.request;

/**
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class BizAnalysisGroupRequestDTO extends BaseRequestDTO {
	/**
	 * 查询条件,类似sql查询
	 */
	private String query;
	/**
	 * 查询的列
	 */
	private String queryColumn;

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

	public String getQueryColumn() {
		return queryColumn;
	}

	public void setQueryColumn(String queryColumn) {
		this.queryColumn = queryColumn;
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
