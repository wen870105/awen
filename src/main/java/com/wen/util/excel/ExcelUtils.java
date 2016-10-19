package com.wen.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.wen.util.StringUtils;

/**
 * excel操作类
 * @author Wen
 * @CreatDate: 2016年6月14日
 */
public class ExcelUtils {

	private static final Log logger = LogFactory.getLog(ExcelUtils.class);
	private static final DecimalFormat df = new DecimalFormat("0");
	
	/**
	 * 导入挂牌信息,和导入商品逻辑相似 不增加库存信息
	 * 
	 * @param user
	 * @param is
	 */
	public static <T> List<T> getExcelList(InputStream is, ExcelResolver<T> resolver) throws ExcelException {
		long start = System.currentTimeMillis();
		List<T> list = null;
		try {
			list = buildList(is, resolver);
		} catch (Exception e) {
			throw new ExcelException("解析excel数据异常", e);
		}
		long end = System.currentTimeMillis();

		String s = String.format("解析excel用时 ： %sms , 数据行数 %s ", (end - start), list.size());
		logger.info(s);
		return list;
	}

	private static <T> List<T> buildList(InputStream is, ExcelResolver<T> resolver) throws Exception {
		Workbook wb = WorkbookFactory.create(is);
		Sheet sheet = wb.getSheetAt(0);
		int rows = sheet.getLastRowNum();

		List<T> list = new ArrayList<T>(rows);

		for (int i = 0; i < rows; i++) {

			T ret = resolver.resolve(sheet, sheet.getRow(i), i);
			if (ret != null) {
				list.add(ret);
			}
		}
		return list;
	}
	public static void main(String[] args) throws Exception {
		String path = "E:\\test1.xls";
//		String path = "E:\\test2.xlsx";
		InputStream is = new FileInputStream(new File(path));
		
		Workbook wb = WorkbookFactory.create(is);
		Sheet sheet = wb.getSheetAt(0);
		int length = sheet.getLastRowNum();
		
		for(int i=0;i<length ;i++){
			Row row = sheet.getRow(i);
			String s = getStringCell(row.getCell(0));
			System.out.print(s);
			s = getStringCell(row.getCell(1));
			System.out.print(s);
			s = getStringCell(row.getCell(6));
			System.out.print(s);
			System.out.println("--");
		}
		
		
		
		/*
		Sheet sheet1 = wb.createSheet("new sheet");
	    Sheet sheet2 = wb.createSheet("second sheet");


	    // You can use org.apache.poi.ss.util.WorkbookUtil#createSafeSheetName(String nameProposal)}
	    // for a safe way to create valid names, this utility replaces invalid characters with a space (' ')
	    String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
	    Sheet sheet3 = wb.createSheet(safeName);
		
		
	    FileOutputStream fileOut = new FileOutputStream("E:\\workbook.xls");
	    wb.write(fileOut);
	    fileOut.close();
	    */
	}
	
	public static String getStringCell(Cell cell){
		if(cell==null){
			return StringUtils.EMPTY;
		}
		String str = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                str = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                	str = cell.getDateCellValue() + "";
                } else {
                	str = df.format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
            	str = cell.getBooleanCellValue() + "";
                break;
            case Cell.CELL_TYPE_FORMULA:
            	str = cell.getCellFormula();
                break;
        }
        return str;
	}
	
	public static void downloadXLS(HttpServletResponse response,String fileName,
			ExcelUtilWritableWorkbook cbWorkBook) throws Exception {
		OutputStream os = response.getOutputStream();// 取得输出流
		response.reset();// 清空输出流
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName + ".xls");// 设定输出文件头
		response.setContentType("application/msexcel");// 定义输出类型
		Workbook wb = new HSSFWorkbook();
		cbWorkBook.initWritableWorkbook(wb);
		wb.write(os);
		os.close(); // 关闭流
	}
	
}
