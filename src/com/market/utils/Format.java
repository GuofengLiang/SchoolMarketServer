package com.market.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 格式化工具类
 * 
 * @author
 * 
 */
public class Format {
	/**
	 * yyyy-MM-dd hh:mm转为date
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date string2Date(String dateString) throws ParseException {
		String[] date = dateString.split(" ");
		String[] date2 = date[0].split("-");
		String[] date3 = date[1].split(":");
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.YEAR, Integer.parseInt(date2[0]));// 设置年
		gc.set(Calendar.MONTH, Integer.parseInt(date2[1]) - 1);// 这里0是1月..以此向后推
		gc.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date2[2]));// 设置天
		gc.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date3[0]));
		gc.set(Calendar.MINUTE, Integer.parseInt(date3[1]));
		return gc.getTime();
	}
}
