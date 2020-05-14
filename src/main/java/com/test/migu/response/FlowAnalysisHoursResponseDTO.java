package com.test.migu.response;

import java.util.List;

/**
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class FlowAnalysisHoursResponseDTO {
	/**
	 * 列信息,报表x轴显示数据
	 */
	private List<String> columns;
	/**
	 * 数据节点
	 */
	private List<SerieDTO> series;

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

}
