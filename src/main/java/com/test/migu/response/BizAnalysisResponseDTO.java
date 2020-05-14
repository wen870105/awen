package com.test.migu.response;

import java.util.List;

/**
 * 业务分析
 * 
 * @author wen
 * @date 2020年3月19日
 */
public class BizAnalysisResponseDTO {
	/**
	 * 字段列表,参考node element
	 */
	private List<EntryDTO> columns;

	public List<EntryDTO> getColumns() {
		return columns;
	}

	public void setColumns(List<EntryDTO> columns) {
		this.columns = columns;
	}

}
