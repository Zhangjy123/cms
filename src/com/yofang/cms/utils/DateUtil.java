package com.yofang.cms.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * 时间工具类
 * 规则格式化字符串时间,字符串规则转化时间类型
 * @author Administrator
 *
 */
public class DateUtil {
	
	/**
	 * 格式化时间为HH:mm的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatHHmm(Date date){
		return new SimpleDateFormat("HH:mm").format(date);
	}
	/**
	 * 格式化时间类型HH:mm
	 * @param time 字符串
	 * @return Date
	 */
	public static Date parseHHmm(String date) {
		try {
			return new SimpleDateFormat("HH:mm").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化时间为yyyyMMdd的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatyyyyMMdd(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}
	
	/**
	 * 格式化时间类型yyyyMMdd
	 * @param date 字符串
	 * @return Date
	 */
	public static Date parseyyyyMMdd(String date){
		try {
			return new SimpleDateFormat("yyyyMMdd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 格式化时间为yyMMddHHmm的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatyyMMddHHmm(Date date) {
		return new SimpleDateFormat("yyMMddHHmm").format(date);
	}
	
	/**
	 * 格式化时间类型yyMMddHHmm
	 * @param dateString 字符串
	 * @return Date
	 */
	public static Date parseyyMMddHHmm(String date) {
		try {
			return new SimpleDateFormat("yyMMddHHmm").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 格式化时间yyyyMMddHHmm的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatyyyyMMddHHmm(Date date) {
		return new SimpleDateFormat("yyyyMMddHHmm").format(date);
	}

	/**
	 * 格式化为时间类型yyyyMMddHHmm
	 * @param date 字符串
	 * @return Date
	 */
	public static Date parseyyyyMMddHHmm(String date) {
		try {
			return new SimpleDateFormat("yyyyMMddHHmm").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化日期为MM-dd的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatMMgdd(Date date) {
		return new SimpleDateFormat("MM-dd").format(date);
	}
	
	/**
	 * 格式化日期为MM/dd的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatMMxgdd(Date date){
		return new SimpleDateFormat("MM/dd").format(date);
	}
	
	/**
	 * 格式化日期为HH:mm:ss MM/dd
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatHHmmssMMxgdd(Date date){
		return new SimpleDateFormat("HH:mm:ss MM/dd").format(date);
	}
	
	/**
	 * 格式化时间为yy/MM/dd HH:mm
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatYYxgMMxgddHHmm(Date date){
		return new SimpleDateFormat("yy/MM/dd HH:mm").format(date);
	}
	
	/**
	 * 格式化时间类型MM-dd
	 * @param date 字符串
	 * @return Date
	 */
	public static Date parseMMgdd(String date){
		try {
			return new SimpleDateFormat("HH-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 格式化时间为yyyy-MM-dd的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatCommon(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	/**
	 * 格式化时间为yyyy/MM/dd的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatXgCommon(Date date){
		return new SimpleDateFormat("yyyy/MM/dd").format(date);
	}

	/**
	 * 格式化时间类型yyyy-MM-dd
	 * @param commonDateString 字符串
	 * @return Date
	 */
	public static Date parseCommon(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 格式化时间类型yyyy/MM/dd
	 * @param commonDateString 字符串
	 * @return Date
	 */
	public static Date parseXgCommon(String date) {
		try {
			return new SimpleDateFormat("yyyy/MM/dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 格式化日期格式为EEE, dd MMM yyyy HH:mm:ss z的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatGMTDate(Date date) {
		DateFormat httpDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
		httpDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		return httpDateFormat.format(date);
	}

	/**
	 * 格式化日期类型EEE, dd MMM yyyy HH:mm:ss z
	 * @param date 字符串
	 * @return
	 */
	public static Date parseGMTDate(String date){
		DateFormat httpDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
		httpDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return httpDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 格式化日期格式为yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatISODate(Date date) {
		DateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'");
		isoDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		return isoDateFormat.format(date);
	}

	/**
	 * 格式化时间类型的yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'
	 * @param dateString 字符串
	 * @return Date
	 */
	public static Date parseISODate(String date) {
		DateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'");
		try {
			return isoDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化时间类型的EEE, dd-MMM-yyyy HH:mm:ss z
	 * @param date 字符串
	 * @return Date
	 */
	public static Date parseCookieDate(String date) {
		DateFormat isoDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss z", Locale.ENGLISH);
		isoDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return isoDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化时间EEE, dd-MMM-yyyy HH:mm:ss z的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatCookieDate(Date date){
		DateFormat isoDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss z", Locale.ENGLISH);
		isoDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		return isoDateFormat.format(date);
	}
	/**
	 * 格式化时间yyyyMMddHHmmss的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatyyyyMMddHHmmss(Date date) {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}

	/**
	 * 格式化时间类型yyyyMMddHHmmss
	 * @param date 字符串
	 * @return Date
	 */
	public static Date parseyyyyMMddHHmmss(String date){
		try {
			return new SimpleDateFormat("yyyyMMddHHmmss").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化当前日期为yyyy的字符串
	 * @return String
	 */
	public static String formatYear() {
		return new SimpleDateFormat("yyyy").format(new Date());
	}

	/**
	 * 格式化时间为yyyy-MM-dd HH:mm:ss的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatFullTime(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 格式化时间为yyyy-MM-dd HH:mm:ss的字符串
	 * @param date long类型
	 * @return String
	 */
	public static String formatFullTime(long date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	/**
	 * 格式化时间为yyyy/MM/dd HH:mm:ss的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatFullxgTime(Date date){
		return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
	}
	
	/**
	 * 格式化时间类型yyyy/MM/dd HH:mm:ss
	 * @param fullTimeString 字符串
	 * @return Date
	 */
	public static Date parseFullxgTime(String fullxgTimeString){
		try {
			return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(fullxgTimeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 格式化时间类型yyyy-MM-dd HH:mm:ss
	 * @param fullTimeString 字符串
	 * @return Date
	 */
	public static Date parseFullTime(String fullTimeString) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fullTimeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化时间为yyyy-MM-dd HH:mm的字符串
	 * @param date 时间类型
	 * @return String
	 */
	public static String formatMinuteTime(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
	}

	/**
	 * 格式化时间类型yyyy-MM-dd HH:mm
	 * @param fullTimeString 字符串
	 * @return Date
	 */
	public static Date parseMinuteTime(String fullTimeString) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(fullTimeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 根据接收的字符串获取起始查询日期
	 * @param date 字符串
	 * @return Date
	 */
	public static Date getInitDate(String date) {
		Date beginDate = DateUtil.parseCommon(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 得到给定日期的下一天时间
	 * @param date 字符串
	 * @return Date
	 */
	public static Date getNextDateInitOfMonth(String date) {
		Date endDate = DateUtil.parseCommon(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 得到给定日期的月初的时间
	 * @param date 给定的日期
	 * @return Date
	 */
	public static Date getBeginDateInitOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 得到查询的起始日期,要得到几天前或几天后的时间
	 * @param date 当前时刻
	 * @param num 正整数可获取前几天，负整数可获取后几天
	 * @return Date
	 */
	public static Date getDateInitByCurrent(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - num);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 指定时间与当前系统相隔时间的描述，如3分钟前，30秒钟前
	 * @param date 指定时间
	 * @return String 返回中文描述字符串
	 */
	public static String since(Date date) {
		if (date == null)
			return "";
		Date now = new Date();
		if (now.before(date)) {
			return "";
		}
		long delta = (now.getTime() - date.getTime()) / 1000;
		if (delta <= 60) {
			if (delta > 10) {
				delta = delta - 5;
			} else {
				if (delta > 5) {
					delta = delta - 3;
				}
			}
			return (int) delta + "秒钟前";
		}
		if (delta <= 60 * 60) {
			long minutes = delta / 60;
			if (minutes > 10) {
				minutes = minutes - 3;
			} else {
				if (minutes > 5) {
					minutes = minutes - 2;
				} else if (minutes > 2) {
					minutes = minutes - 1;
				}
			}
			return (int) minutes + "分钟前";
		}
		if (delta <= 24 * 60 * 60) {
			long hours = delta / (60 * 60);
			return (int) hours + "小时前";
		}

		if (delta < 7 * 24 * 60 * 60) {
			long days = delta / (24 * 60 * 60);
			return (int) days + "天前";
		}

		if (7 * 24 * 60 * 60 < delta && delta < 30 * 24 * 60 * 60) {
			long weekends = delta / (7 * 24 * 60 * 60);
			return (int) weekends + "周前";
		}

		if (30 * 24 * 60 * 60 < delta && delta < 180 * 24 * 60 * 60) {
			long months = delta / (30 * 24 * 60 * 60);
			return (int) months + "月前";
		}

		if (180 * 24 * 60 * 60 < delta && delta < 365 * 24 * 60 * 60) {
			return "半年前";
		}

		long years = delta / (365 * 24 * 60 * 60);
		return (int) years + "年前";
	}
	
	/**
	 * 清空时分秒毫秒
	 * @param date
	 * @return
	 */
	private static Date clearHHMMSS(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	/** 上周日*/
	public static final String LASTSUNDAY = "lastsunday";
	/** 周一*/
	public static final String MONDAY = "monday";
	/** 周二*/
	public static final String TUESDAY = "tuesday";
	/** 周三*/
	public static final String WEDNESDAY = "wednesday";
	/** 周四*/
	public static final String THURSDAY = "thursday";
	/** 周五*/
	public static final String FRIDAY = "friday";
	/** 周六*/
	public static final String SATURDAY = "saturday";
	/** 周日*/
	public static final String SUNDAY = "sunday";
	/** 下周一*/
	public static final String NEXTMONDAY = "nextmonday";
	/**
	 * 获取当前一周开始时间和结束时间(包括上周日和下周一)
	 * @param date 当前时间
	 * @return Map<String, Date> key:上周日至下周一,Date:具体时间(00:00:00开始)
	 */
	public static Map<String, Date> getCurrentWeek(Date date){
		Map<String, Date> week = new HashMap<String, Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		//判断当前是否为这周日
		boolean thisSunday = true;//默认是这周日
		if(day == Calendar.SUNDAY){
			thisSunday = false;
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//获取周日的日期
		Date lastsunday = cal.getTime();
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(lastsunday);
		if(thisSunday){
			cal1.add(Calendar.DAY_OF_YEAR, 1);
		}else{
			cal1.add(Calendar.DAY_OF_YEAR, -6);
		}
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(lastsunday);
		if(thisSunday){
			cal2.add(Calendar.DAY_OF_YEAR, 2);
		}else{
			cal2.add(Calendar.DAY_OF_YEAR, -5);
		}
		
		Calendar cal3 = Calendar.getInstance();
		cal3.setTime(lastsunday);
		if(thisSunday){
			cal3.add(Calendar.DAY_OF_YEAR, 3);
		}else{
			cal3.add(Calendar.DAY_OF_YEAR, -4);
		}
		
		Calendar cal4 = Calendar.getInstance();
		cal4.setTime(lastsunday);
		if(thisSunday){
			cal4.add(Calendar.DAY_OF_YEAR, 4);
		}else{
			cal4.add(Calendar.DAY_OF_YEAR, -3);
		}
		
		Calendar cal5 = Calendar.getInstance();
		cal5.setTime(lastsunday);
		if(thisSunday){
			cal5.add(Calendar.DAY_OF_YEAR, 5);
		}else{
			cal5.add(Calendar.DAY_OF_YEAR, -2);
		}
		Calendar cal6 = Calendar.getInstance();
		cal6.setTime(lastsunday);
		if(thisSunday){
			cal6.add(Calendar.DAY_OF_YEAR, 6);
		}else{
			cal6.add(Calendar.DAY_OF_YEAR, -1);
		}
		
		Calendar cal7 = Calendar.getInstance();
		cal7.setTime(lastsunday);
		if(thisSunday){
			cal7.add(Calendar.DAY_OF_YEAR, 7);
		}else{
			cal7.add(Calendar.DAY_OF_YEAR, -7);
		}
		
		Calendar cal8 = Calendar.getInstance();
		cal8.setTime(lastsunday);
		if(thisSunday){
			cal8.add(Calendar.DAY_OF_YEAR, 8);
		}else{
			cal8.add(Calendar.DAY_OF_YEAR, 1);
		}
		week.put(LASTSUNDAY, thisSunday?clearHHMMSS(lastsunday):clearHHMMSS(cal7.getTime()));
		week.put(MONDAY, clearHHMMSS(cal1.getTime()));
		week.put(TUESDAY, clearHHMMSS(cal2.getTime()));
		week.put(WEDNESDAY, clearHHMMSS(cal3.getTime()));
		week.put(THURSDAY, clearHHMMSS(cal4.getTime()));
		week.put(FRIDAY, clearHHMMSS(cal5.getTime()));
		week.put(SATURDAY, clearHHMMSS(cal6.getTime()));
		week.put(SUNDAY, thisSunday?clearHHMMSS(cal7.getTime()):clearHHMMSS(lastsunday));
		week.put(NEXTMONDAY, clearHHMMSS(cal8.getTime()));
		return week;
	}
	
	/** 今天*/
	public static final String TODAY = "today";
	/** 明天*/
	public static final String TOMORROW = "tomorrow";
	/**
	 * 获取今天零时和明天零时
	 * @return Map<String, Date>
	 */
	public static Map<String, Date> getToday(){
		Map<String, Date> twodays = new HashMap<String, Date>();
		Calendar cal = Calendar.getInstance();
		twodays.put(TODAY, clearHHMMSS(cal.getTime()));
		cal.add(Calendar.DAY_OF_YEAR, 1);
		twodays.put(TOMORROW, clearHHMMSS(cal.getTime()));
		return twodays;
	}
	
	/** 天数*/
	public static final String DAY = "day";
	/** 小时*/
	public static final String HOUR = "hour";
	/** 分*/
	public static final String MINUTE = "minute";
	/** 秒*/
	public static final String SECOND = "second";
	/**
	 * 剩余时间
	 * @param endDate
	 * @return Map<String, Stirng>
	 */
	public static Map<String, String> remainTime(Date endDate){
		Map<String, String> remain = new HashMap<String, String>();
		Date now = new Date();
		long seconds = endDate.getTime() - now.getTime();
		if(seconds > 0){
			int day = (int)seconds/(1000*60*60*24);
			if(day > 0) {
				remain.put(DAY, String.valueOf(day));
				seconds = seconds - (1000*60*60*24*day);
				remain = getHHmmss(remain, seconds);
			}else {
				remain.put(DAY, "00");
				remain = getHHmmss(remain, seconds);
			}
		}
		return remain;
	}
	
	private static Map<String, String> getHHmmss(Map<String, String> remain, long seconds){
		int hours = (int)seconds/(1000*60*60);
		if(hours > 0){
			remain.put(HOUR, (hours>=10?String.valueOf(hours):"0"+hours));
			seconds = seconds - (1000*60*60*hours);
			int minutes = (int)seconds/(1000*60);
			if(minutes > 0){
				remain.put(MINUTE, (minutes>=10?String.valueOf(minutes):"0"+minutes));
				seconds = seconds - (1000*60*minutes);
				if((seconds/1000) > 0){
					remain.put(SECOND, (seconds/1000>=10?String.valueOf(seconds/1000):"0"+seconds/1000));
				}else{
					remain.put(SECOND, "00");
				}
			}else{
				remain.put(MINUTE, "00");
				if((seconds/1000) > 0){
					remain.put(SECOND, (seconds/1000>=10?String.valueOf(seconds/1000):"0"+seconds/1000));
				}else{
					remain.put(SECOND, "00");
				}
			}
		}else{
			remain.put(HOUR, "00");
			int minutes = (int)seconds/(1000*60);
			if(minutes > 0){
				remain.put(MINUTE, (minutes>=10?String.valueOf(minutes):"0"+minutes));
				seconds = seconds - (1000*60*minutes);
				if((seconds/1000) > 0){
					remain.put(SECOND, (seconds/1000>=10?String.valueOf(seconds/1000):"0"+seconds/1000));
				}else{
					remain.put(SECOND, "00");
				}
			}else{
				remain.put(MINUTE, "00");
				if((seconds/1000) > 0){
					remain.put(SECOND, (seconds/1000>=10?String.valueOf(seconds/1000):"0"+seconds/1000));
				}else{
					remain.put(SECOND, "00");
				}
			}
		}
		return remain;
	}
	/**
	 * 在起始日期上 增加 天 小时 分钟
	 * @param startDate 起始日期
	 * @param day 增加天数
	 * @param hour 增加小时
	 * @param minute 增加分钟
	 * @return Date 结束日期
	 */
	public static Date startToEnd(Date startDate,int day,int hour,int minute,int second){
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR)+day);
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)+hour);
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)+minute);
		cal.set(Calendar.SECOND, cal.get(Calendar.SECOND)+second);
		return cal.getTime();
	}
	
	public static int getDay(Date startdate,Date enddate){
		long startTime = startdate.getTime();
		long endTime = enddate.getTime();
		long temp = endTime-startTime;
		if(temp <= 0) return 0;
		long day = temp/(1000*60*60*24);
		return new Long(day).intValue();
	}
	
	public static int getHour(Date startdate,Date enddate){
		long startTime = startdate.getTime();
		long endTime = enddate.getTime();
		long temp = endTime-startTime;
		if(temp <= 0) return 0;
		long hour = temp%(1000*60*60*24)/(1000*60*60);
		return new Long(hour).intValue();
	}
	
	public static int getMinute(Date startdate,Date enddate){
		long startTime = startdate.getTime();
		long endTime = enddate.getTime();
		long temp = endTime-startTime;
		if(temp <= 0) return 0;
		long minute = temp%(1000*60*60*24)%(1000*60*60)/(1000*60);
		return new Long(minute).intValue();
	}
	
	public static int getSecond(Date startdate,Date enddate){
		long startTime = startdate.getTime();
		long endTime = enddate.getTime();
		long temp = endTime-startTime;
		if(temp <= 0) return 0;
		long second = temp%(1000*60*60*24)%(1000*60*60)%(1000*60)/1000;
		return new Long(second).intValue();
	}
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start = "2013-07-22 15:10:32";
		try {
			Date startdate = sdf.parse(start);
			Date enddate = startToEnd(startdate, 33, 3, 4, 55);
			System.out.println(sdf.format(enddate));
			int day = getDay(startdate, enddate);
			int hour = getHour(startdate, enddate);
			int minute = getMinute(startdate, enddate);
			int second = getSecond(startdate, enddate);
			System.out.println(day);
			System.out.println(hour);
			System.out.println(minute);
			System.out.println(second);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
