package com.wen.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 金钱转换 
 * @author Wen
 * @CreatDate: 2016年3月2日
 */
public class MoneyUtils {

	private static final String pattern = "###########0.##";

	/**
	 * 显示钱前面有￥
	 * @param fen
	 * @return
	 */
	public static String formatFenToYuanTxt(Long fen) {
		if (fen == null) {
			return null;
		}
		NumberFormat nf = new DecimalFormat(pattern);
		return "￥" + nf.format(fenToYuan(fen));
	}

	public static double formatFenToYuan(Long fen) {
		if (fen == null) {
			return 0;
		}
		return fenToYuan(fen).doubleValue();
	}

	/**
	 * 元转换成分
	 * @param yuan
	 * @return
	 * @author Hexi
	 */
	public static Long yuanToFen(Double yuan) {
		if (null == yuan)
			return null;
		return yuanToFen(new BigDecimal(yuan));
	}

	/**
	 * 元转换成分
	 *
	 * @param yuan
	 *
	 * @return
	 */
	public static Long yuanToFen(BigDecimal yuan) {
		if (null == yuan)
			return null;
		return yuan.multiply(new BigDecimal(100)).longValue();
	}

	/**
	 * 分转换成元
	 *
	 * @param fen
	 * @return
	 */
	public static BigDecimal fenToYuan(Long fen) {
		if (null == fen)
			return null;

		return new BigDecimal(fen).divide(new BigDecimal(100));
	}
	
	public static String format(Double money){
		NumberFormat nf = new DecimalFormat(pattern);
		return nf.format(money);
	}
	
}
