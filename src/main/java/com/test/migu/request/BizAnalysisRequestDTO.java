package com.test.migu.request;

/**
 * 业务分析
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
	private String type;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
