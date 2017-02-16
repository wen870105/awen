package com.wen.util;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;

/**
 * 
 * @author Wen
 * @CreatDate: 2016年6月15日
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	public static final String yyyyMMdd = "yyyy-MM-dd";
	public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 允许的文件类型
	 * @param filename
	 * @param exts 后缀名
	 * @return
	 */
	public static boolean acceptExtension(String filename, String... exts) {
		if (isNotEmpty(filename)) {
			String fileext = FilenameUtils.getExtension(filename);
			for (String e : exts) {
				if (equalsIgnoreCase(e, fileext)) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * 日期间隔天数
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static int getIntervalDays(Date from, Date to) {
		long result = to.getTime() - from.getTime();
		int day = (int) result / (1000 * 60 * 60 * 24);
		return day;
	}

	public static String formateDate(Date date) {
		return formateDate(date, yyyyMMdd);
	}

	public static String formateDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Date dateFormate(String strDate) {
		DateFormat df = new SimpleDateFormat(yyyyMMdd);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getMonthFirst(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return formateDate(calendar.getTime());
	}

	public static String getMonthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return formateDate(calendar.getTime());
	}

	public static String messageFormat(String pMsg, Object... pArgs) {
		return MessageFormat.format(pMsg, pArgs);
	}

	public static String[] convertString(String args, String splitChart) {
		if (StringUtils.isEmpty(args))
			return new String[] {};
		return args.trim().split(splitChart);
	}
	
	/**
	 * 格式化字符串, abc {aaa} efg {bbb}, {aaa}
	 * map={aaa=123,bbb=456}
	 * 结果: abc 123 efg 456, 123
	 * @param param
	 * @param map
	 * @return
	 */
	public static String formatReplace(String param,Map<String,String> map){
		if(isNotBlank(param) && map!=null){
			String ret = param;
			for(Map.Entry<String, String> en : map.entrySet()){
				ret = ret.replace("{"+en.getKey()+"}", en.getValue());
			}
			return ret;
		}
		return param;
	}
	

	public static void main(String[] args) {

		String s = messageFormat("Test {0} is {1}", "wen", "test");
		System.out.println(s);
		Date d = new Date();
		String first = getMonthFirst(d);
		String end = getMonthEnd(d);
		String sss = formateDate(d);
		System.out.println(sss);
		System.out.println(first);
		System.out.println(end);
		String str = "abc {aaa} efg {bbb}, {aaa}";
		Map<String, String> map = StringToMap.convert("aaa=123","bbb=456");
		System.out.println(formatReplace(str, map)); 

	}
}
