package com.newcitysoft.study.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 11:59
 */
public class DateTimeFormatterDemo {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;

        String formattedDate = formatter.format(LocalDate.now());
        String formattedZonedDate = formatter.format(ZonedDateTime.now());

        System.out.println(formattedDate);
        System.out.println(formattedZonedDate);


        LocalDateTime localDateTime = LocalDateTime.now();
        String date1 = localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        String date2 = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String date3 = localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        String date4 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String date5 = localDateTime.format(DateTimeFormatter.ofPattern("今天是：YYYY年 MMMM dd日 E", Locale.CHINESE));
        String date6 = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date4);
        System.out.println(date5);
        System.out.println(date6);

        // 将一个字符串解析成一个日期对象
        String date7 = "2018-04-02";
        String date8 = "2017-04-02 15:30:05";

        LocalDate date = LocalDate.parse(date7, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime dateTime = LocalDateTime.parse(date8, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println(date);
        System.out.println(dateTime);


    }
}
