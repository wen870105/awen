package com.wen.util.excel;


/**
 * 
 * @author Wen
 * @CreatDate: 2016年6月14日
 */
public class ExcelException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7419953305116967415L;

	public ExcelException(String message) {
		super(message);
	}

	public ExcelException(String message, Throwable cause) {
		super(message, cause);
	}
}
