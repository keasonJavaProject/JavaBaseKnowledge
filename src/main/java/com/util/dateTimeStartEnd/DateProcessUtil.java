package com.util.dateTimeStartEnd;


import com.util.dateFormat.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateProcessUtil {

    /**
     * 获取昨天
     * @return
     */
    public static String getYesterday(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        Date time=calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取今天
     * @return
     */
    public static String getToday(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取上周的第一天
     * @return String
     * **/
    public static String getLastWeekStart(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        calendar.add(Calendar.DATE, 2 - dayofweek - 7);
        Date time=calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取上周的最后一天
     * @return String
     * **/
    public static String getLastWeekEnd(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        calendar.add(Calendar.DATE, 2 - dayofweek - 7);
        calendar.add(Calendar.DATE, 6);
        Date time=calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }





    /**
     * 获取本周的第一天
     * @return String
     * **/
    public static String getWeekStart(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        calendar.add(Calendar.DATE, 2 - dayofweek);
        Date time=calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取本周的最后一天
     * @return String
     * **/
    public static String getWeekEnd(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        calendar.add(Calendar.DATE, 2 - dayofweek);
        calendar.add(Calendar.DATE, 6);
        Date time = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }





    /**
     * 获取本月开始日期
     * @return String
     * **/
    public static String getMonthStart(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date time=calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取本月最后一天
     * @return String
     * **/
    public static String getMonthEnd(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time=calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }




    /**
     * 获取上月开始日期
     * @return String
     * **/
    public static String getLastMonthStart(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date time=calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取上月最后一天
     * @return String
     * **/
    public static String getLastMonthEnd(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time=calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }






    /**
     * 获取本年的第一天
     * @return String
     * **/
    public static String getYearStart(){
        return new SimpleDateFormat("yyyy").format(new Date())+"-01-01";
    }

    /**
     * 获取本年的最后一天
     * @return String
     * **/
    public static String getYearEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH,calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date currYearLast = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(currYearLast);
    }





    /**
     * 获取上一年的第一天
     * @return String
     * **/
    public static String getLastYearStart(){
        LocalDateTime localDateTime = LocalDateTime.now().plusYears(-1);
        return localDateTime.getYear() + "-01-01";
    }

    /**
     * 获取上一年的最后一天
     * @return String
     * **/
    public static String getLastYearEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH,calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.YEAR, -1);
        Date currYearLast = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(currYearLast);
    }





    /**
     * 获取当前季度
     *
     */
    public static int getQuarter() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;
        int quarter = 0;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else {
            quarter = 4;
        }
        return quarter;
    }

    /**
     * 获取某季度的第一天和最后一天
     *	@param num 第几季度
     */
    public static String[] getQuarterDate(int num) {
        String[] s = new String[2];
        String str = "";
        // 设置本年的季
        Calendar quarterCalendar = null;
        switch (num) {
            case 0: //上一季度:
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 12);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.YEAR, -1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = DateFormatUtils.getFormatDateTime(quarterCalendar.getTime(), DateFormatUtils.DATE_FORMAT_YYYY_MM_DD);
                s[0] = str.substring(0, str.length() - 5) + "09-01";
                s[1] = str;
                break;
            case 1: // 本年到现在经过了一个季度，在加上前4个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 3);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = DateFormatUtils.getFormatDateTime(quarterCalendar.getTime(), DateFormatUtils.DATE_FORMAT_YYYY_MM_DD);
                s[0] = str.substring(0, str.length() - 5) + "01-01";
                s[1] = str;
                break;
            case 2: // 本年到现在经过了二个季度，在加上前三个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 6);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = DateFormatUtils.getFormatDateTime(quarterCalendar.getTime(), DateFormatUtils.DATE_FORMAT_YYYY_MM_DD);
                s[0] = str.substring(0, str.length() - 5) + "04-01";
                s[1] = str;
                break;
            case 3:// 本年到现在经过了三个季度，在加上前二个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 9);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = DateFormatUtils.getFormatDateTime(quarterCalendar.getTime(), DateFormatUtils.DATE_FORMAT_YYYY_MM_DD);
                s[0] = str.substring(0, str.length() - 5) + "07-01";
                s[1] = str;
                break;
            case 4:// 本年到现在经过了四个季度，在加上前一个季度
                quarterCalendar = Calendar.getInstance();
                str = DateFormatUtils.getFormatDateTime(quarterCalendar.getTime(), DateFormatUtils.DATE_FORMAT_YYYY_MM_DD);
                s[0] = str.substring(0, str.length() - 5) + "10-01";
                s[1] = str.substring(0, str.length() - 5) + "12-31";
                break;
        }
        return s;
    }


	public static Integer getDaysBetween(Date fromDate, Date endDate){
		Integer result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(sdf.format(fromDate)));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(sdf.format(endDate)));
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			result = Integer.parseInt(String.valueOf(between_days));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
            e.printStackTrace();
		}
		return result;
	}

}
