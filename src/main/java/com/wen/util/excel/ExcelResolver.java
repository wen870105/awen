package com.wen.util.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * 
 * @author Wen
 * @CreatDate: 2016年6月14日
 */
public abstract class ExcelResolver<T> {
	
	/**
	 * 
	 * @param sheet
	 * @param row 当前行的数据
	 * @param index 当前解析时的下标,通常0需要跳过
	 * @return
	 */
	public abstract T resolve(Sheet sheet, Row row, int index);

	/**
	 * 取得excel中的值如果为空使用""作为默认值
	*
	* @param cell
	* @return
	 */
	protected String getCellContent(Row row, int index) {
		// 检查数组越界
		if (row != null && row.getLastCellNum()  > index ) {
			Cell cell = row.getCell(index);
			return ExcelUtils.getStringCell(cell);
		}
		return null;
	}
	
}
