package com.newcitysoft.study.java8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 11:30
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        // 1.创建一个LocalDate
        LocalDate now = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2018, 3, 3);
        // 2.访问日期信息
        int year = now.getYear();
        Month month = now.getMonth();
        int dayOfMonth = now.getDayOfMonth();
        int dayOfYear = now.getDayOfYear();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        System.out.println(year);
        System.out.println(month);
        System.out.println(dayOfMonth);
        System.out.println(dayOfYear);
        System.out.println(dayOfWeek);
        //3.计算
        System.out.println(now.plusDays(1));
        System.out.println(now.minusMonths(2));
    }
}
