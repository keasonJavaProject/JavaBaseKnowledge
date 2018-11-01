package com.util.dateFormat;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/11/1 14:33
 */
public class DateFormatUtils {
    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    public static String getFormatDateTime(Date date, String format) {
        String dateStr = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            dateStr = sdf.format(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dateStr;
    }

    public static Date parseDateTime(String dateStr, String format) {
        Date dateRet = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            dateRet = sdf.parse(dateStr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dateRet;
    }

    public static void main(String[] args) {
        System.out.println(DateFormatUtils.getFormatDateTime(new Date(), DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS));

        System.out.println(DateFormatUtils.getFormatDateTime(DateFormatUtils.parseDateTime("2018-10-10",DATE_FORMAT_YYYY_MM_DD),DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS));
    }
}
