package com.test;

import com.util.dateFormat.DateFormatUtils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyLocalDateTime {
    /**
     * all method:
     * 1.	adjustInto	调整指定的Temporal和当前LocalDateTime对
     * 2.	atOffset	结合LocalDateTime和ZoneOffset创建一个
     * 3.	atZone	结合LocalDateTime和指定时区创建一个ZonedD
     * 4.	compareTo	比较两个LocalDateTime
     * 5.	format	格式化LocalDateTime生成一个字符串
     * 6.	from	转换TemporalAccessor为LocalDateTi
     * 7.	get	得到LocalDateTime的指定字段的值
     * 8.	getDayOfMonth	得到LocalDateTime是月的第几天
     * 9.	getDayOfWeek	得到LocalDateTime是星期几
     * 10.	getDayOfYear	得到LocalDateTime是年的第几天
     * 11.	getHour	得到LocalDateTime的小时
     * 12.	getLong	得到LocalDateTime指定字段的值
     * 13.	getMinute	得到LocalDateTime的分钟
     * 14.	getMonth	得到LocalDateTime的月份
     * 15.	getMonthValue	得到LocalDateTime的月份，从1到12
     * 16.	getNano	得到LocalDateTime的纳秒数
     * 17.	getSecond	得到LocalDateTime的秒数
     * 18.	getYear	得到LocalDateTime的年份
     * 19.	isAfter	判断LocalDateTime是否在指定LocalDateT
     * 20.	isBefore	判断LocalDateTime是否在指定LocalDateT
     * 21.	isEqual	判断两个LocalDateTime是否相等
     * 22.	isSupported	判断LocalDateTime是否支持指定时间字段或单元
     * 23.	minus	返回LocalDateTime减去指定数量的时间得到的值
     * 24.	minusDays	返回LocalDateTime减去指定天数得到的值
     * 25.	minusHours	返回LocalDateTime减去指定小时数得到的值
     * 26.	minusMinutes	返回LocalDateTime减去指定分钟数得到的值
     * 27.	minusMonths	返回LocalDateTime减去指定月数得到的值
     * 28.	minusNanos	返回LocalDateTime减去指定纳秒数得到的值
     * 29.	minusSeconds	返回LocalDateTime减去指定秒数得到的值
     * 30.	minusWeeks	返回LocalDateTime减去指定星期数得到的值
     * 31.	minusYears	返回LocalDateTime减去指定年数得到的值
     * 32.	now	返回指定时钟的当前LocalDateTime
     * 33.	of	根据年、月、日、时、分、秒、纳秒等创建LocalDateTi
     * 34.	ofEpochSecond	根据秒数(从1970-01-0100:00:00开始)创建L
     * 35.	ofInstant	根据Instant和ZoneId创建LocalDateTim
     * 36.	parse	解析字符串得到LocalDateTime
     * 37.	plus	返回LocalDateTime加上指定数量的时间得到的值
     * 38.	plusDays	返回LocalDateTime加上指定天数得到的值
     * 39.	plusHours	返回LocalDateTime加上指定小时数得到的值
     * 40.	plusMinutes	返回LocalDateTime加上指定分钟数得到的值
     * 41.	plusMonths	返回LocalDateTime加上指定月数得到的值
     * 42.	plusNanos	返回LocalDateTime加上指定纳秒数得到的值
     * 43.	plusSeconds	返回LocalDateTime加上指定秒数得到的值
     * 44.	plusWeeks	返回LocalDateTime加上指定星期数得到的值
     * 45.	plusYears	返回LocalDateTime加上指定年数得到的值
     * 46.	query	查询LocalDateTime
     * 47.	range	返回指定时间字段的范围
     * 48.	toLocalDate	返回LocalDateTime的LocalDate部分
     * 49.	toLocalTime	返回LocalDateTime的LocalTime部分
     * 50.	toString	返回LocalDateTime的字符串表示
     * 51.	truncatedTo	返回LocalDateTime截取到指定时间单位的拷贝
     * 52.	until	计算LocalDateTime和另一个LocalDateTi
     * 53.	with	返回LocalDateTime指定字段更改为新值后的拷贝
     * 54.	withDayOfMonth	返回LocalDateTime月的第几天更改为新值后的拷贝
     * 55.	withDayOfYear	返回LocalDateTime年的第几天更改为新值后的拷贝
     * 56.	withHour	返回LocalDateTime的小时数更改为新值后的拷贝
     * 57.	withMinute	返回LocalDateTime的分钟数更改为新值后的拷贝
     * 58.	withMonth	返回LocalDateTime的月份更改为新值后的拷贝
     * 59.	withNano	返回LocalDateTime的纳秒数更改为新值后的拷贝
     * 60.	withSecond	返回LocalDateTime的秒数更改为新值后的拷贝
     * 61.	withYear	返回LocalDateTime年份更改为新值后的拷贝
     *
     */
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.plusYears(1);
        localDateTime = localDateTime.plusMonths(1);
        localDateTime = localDateTime.plusDays(1);
        localDateTime = localDateTime.plusHours(1);
        localDateTime = localDateTime.plusMinutes(1);
        localDateTime = localDateTime.plusSeconds(1);
        System.out.println("当前时间 加时间"+localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));


        localDateTime = LocalDateTime.of(2019, 10, 10, 0, 0, 12);
        System.out.println("当前时间 指定时间of "+localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));


        localDateTime = localDateTime.withYear(2010);
        localDateTime = localDateTime.withMonth(12);
        System.out.println("当前时间 指定时间with " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

//        LocalDateTime 转化为Date
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println("当前时间 toDate     " + DateFormatUtils.getFormatDateTime(date,DateFormatUtils.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));

        //Date.toInstant()
        localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("当前时间 指定时间 toLocalDateTime "+localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        //Calendar.toInstant()

        System.out.println("\n计算时间差");
        LocalDateTime start = LocalDateTime.of(2017, 1, 1, 1, 1);
        LocalDateTime end = LocalDateTime.of(2017, 2, 1, 1, 1);

        Duration result = Duration.between(start, end);
        System.out.println(result.toDays()); //31
        System.out.println(result.toHours()); //744
        System.out.println(result.toMinutes()); //44640
        System.out.println(result.toMillis()); //2678400000
        System.out.println(result.toNanos()); //2678400000000000
    }
}
