package com.wen.util.excel;

import org.apache.poi.ss.usermodel.Workbook;


/**
 * 下载excel相关
 * @author Wen
 * @CreatDate: 2015年3月1日
 */
public interface ExcelUtilWritableWorkbook {
	public void initWritableWorkbook(Workbook workbook) throws Exception; 
}
