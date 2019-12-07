
package com.baijiaxiu.services.cloud.common.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 日期处理
 * @author: liuyufeng
 * @date: 2019-08-30 17:14
 */
@Slf4j
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 时间格式(yyyyMMdd)
     */
    public final static String DATE_SIMPLE_PATTERN = "yyyyMMdd";

    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     *
     * @param date 日期
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     *
     * @param date    日期
     * @param pattern 格式，如：DateUtils.DATE_TIME_PATTERN
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 字符串转换成日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期的格式，如：DateUtils.DATE_TIME_PATTERN
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (StringUtils.isBlank(strDate)) {
            return null;
        }

        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.parseLocalDateTime(strDate).toDate();
    }

    /**
     * 根据周数，获取开始日期、结束日期
     *
     * @param week 周期  0本周，-1上周，-2上上周，1下周，2下下周
     * @return 返回date[0]开始日期、date[1]结束日期
     */
    public static Date[] getWeekStartAndEnd(int week) {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.plusWeeks(week));
        date = date.dayOfWeek().withMinimumValue();
        Date beginDate = date.toDate();
        Date endDate = date.plusDays(6).toDate();
        return new Date[]{beginDate, endDate};
    }

    /**
     * 对日期的【秒】进行加/减
     *
     * @param date    日期
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addDateSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();
    }

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param date    日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * 对日期的【小时】进行加/减
     *
     * @param date  日期
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addDateHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * 对日期的【天】进行加/减
     *
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDateDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * 对日期的【周】进行加/减
     *
     * @param date  日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * 对日期的【月】进行加/减
     *
     * @param date   日期
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addDateMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 对日期的【年】进行加/减
     *
     * @param date  日期
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addDateYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }


    /**
     * 两个日期相关天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDateDiff(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0L;
        }
        long diff = (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000);
        return diff;
    }

    /**
     * 相差多少小时
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDateDiffHour(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0L;
        }
        long diff = (date1.getTime() - date2.getTime()) / (60 * 60 * 1000) > 0 ? (date1.getTime() - date2.getTime()) / (60 * 60 * 1000) : (date2.getTime() - date1.getTime()) / (60 * 60 * 1000);
        return diff;
    }


    /**
     * 相差多少分钟
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDateDiffMinute(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0L;
        }
        long diff = (date1.getTime() - date2.getTime()) / (60 * 1000);
        return diff;
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime   当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 时间比较（如果myDate>compareDate返回1，<返回-1，相等返回0）
     *
     * @param myDate      时间
     * @param compareDate 要比较的时间
     * @return int
     */
    public static int dateCompare(Date myDate, Date compareDate) {
        Calendar myCal = Calendar.getInstance();
        Calendar compareCal = Calendar.getInstance();
        myCal.setTime(myDate);
        compareCal.setTime(compareDate);
        return myCal.compareTo(compareCal);
    }


    /**
     * @param date1  字符串日期1
     * @param date2  字符串日期2
     * @param format 日期格式化方式  format="yyyy-MM-dd"
     * @return
     * @descript: 计算两个字符串日期相差的天数
     */
    public static long dayDiff(String date1, String date2, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        long diff = 0L;
        try {
            long d1 = dateFormat.parse(date1).getTime();
            long d2 = dateFormat.parse(date2).getTime();
            diff = (d1 - d2) / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

    /**
     * 计算两个日期的环比日期
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param format    日期格式 format="yyyy-MM-dd"
     * @return
     */
    public static String[] linkRelativeDate(String startTime, String endTime, String format) {
        Long difference = dayDiff(startTime, endTime, format);
        Date startDate = stringToDate(startTime, format);
        Date endDate = stringToDate(endTime, format);
        Long l = difference - 1;
        Date date = addDateDays(startDate, l.intValue());
        Date date2 = addDateDays(endDate, l.intValue());
        String format1 = format(date, format);
        String format2 = format(date2, format);
        return new String[]{format1, format2};
    }


    /**
     * 将字符串格式yyyyMMdd的字符串转为日期，格式"yyyy-MM-dd"
     * 将字符串格式pattern1的字符串转为日期字符串pattern2，格式"yyyy-MM-dd"
     *
     * @param date 日期字符串
     * @return 返回格式化的日期
     * @throws ParseException 分析时意外地出现了错误异常
     */
    public static String strToDateFormat(String date, String pattern1, String pattern2) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern1);
        formatter.setLenient(false);
        Date newDate = null;
        try {
            newDate = formatter.parse(date);
            formatter = new SimpleDateFormat(pattern2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatter.format(newDate);
    }

    public static void main(String[] args) {
//        Date time1 = DateUtils.addDateMinutes(new Date(), 5);
//        long time = DateUtils.getDateDiffMinute(new Date(), time1);
//        System.out.println(time);

        String today = DateUtils.format(new Date());
        Date endTime = DateUtils.stringToDate(today + " 23:00:00", DateUtils.DATE_TIME_PATTERN);
        Date startTime = DateUtils.stringToDate(today + " 9:00:00", DateUtils.DATE_TIME_PATTERN);
        Date date = DateUtils.addDateDays(new Date(), -1);
        System.out.println(isEffectiveDate(date, startTime, endTime));

    }


}
