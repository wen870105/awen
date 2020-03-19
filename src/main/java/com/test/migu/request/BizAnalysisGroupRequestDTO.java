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

}
