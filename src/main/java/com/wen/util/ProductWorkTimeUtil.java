package com.wen.util;

import java.text.NumberFormat;

/**
 * 商品工作时间转换工具类
 * 把0800转换为08:00
 * @author Wen
 * @CreatDate: 2016年2月24日
 */
public class ProductWorkTimeUtil {
	/**
	 * 格式化商品时间
	 * 商品时间当前格式为xxxx或者xxx,如果是3位需要补0
	 * @param time
	 * @return
	 */
	public static String formatWorkTime(Integer startOrEndTime, String connector){
		if(startOrEndTime == null){
			return null;
		}
		NumberFormat nf = NumberFormat.getInstance();
		// 设置是否使用分组  
		nf.setGroupingUsed(false);
		// 设置最大整数位数  
		nf.setMaximumIntegerDigits(4);
		// 设置最小整数位数  
		nf.setMinimumIntegerDigits(4);
		// 输出测试语句  
		String ret = nf.format(startOrEndTime);
		return ret.substring(0, 2) + connector + ret.substring(2);
	}
	
	/**
	 * 格式化商品时间
	 * 商品时间当前格式为xxxx或者xxx,如果是3位需要补0
	 * @param time
	 * @return
	 */
	public static String formatWorkTime(Integer startOrEndTime){
		return formatWorkTime(startOrEndTime, ":");
	}
	
	/**
	 * 工作时长,只考虑小时部分未考虑分钟的计算
	 * @param endTime
	 * @param startTime
	 * @return
	 */
	public static int timediff(Integer endTime,Integer startTime){
		if(endTime == null || startTime == null){
			return 0;
		}
		int ret = endTime - startTime;
		return ret/100;
	}
	
	public static void main(String[] args) {
		int a = 830;
		int b = 1000;
		System.out.println(formatWorkTime(a));
		System.out.println(formatWorkTime(b));
	}
}