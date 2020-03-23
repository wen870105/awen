package com.test.migu.response;

import java.util.List;

/**
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class BizAnalysisGroupResponseDTO {
	/**
	 * 字段列表,来自入参数据
	 */
	private List<String> columns;
	/**
	 * 字段列表对应的值
	 */
	private List<SerieDTO> series;

	/**
	 * 分页页码,起始页,默认值都是1
	 */
	private Integer pageIndex;

	/**
	 * 分页大小,默认是20
	 */
	private Integer pageSize;

	/**
	 * 分页总条数
	 */
	private Integer pageTotal;

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public List<SerieDTO> getSeries() {
		return series;
	}

	public void setSeries(List<SerieDTO> series) {
		this.series = series;
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

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

}
