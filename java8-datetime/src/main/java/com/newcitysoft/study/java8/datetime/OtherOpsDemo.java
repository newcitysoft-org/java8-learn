package com.newcitysoft.study.java8.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.lastInMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 12:49
 */
public class OtherOpsDemo {

    private static void demo1() {
        // 2017-01-05
        //LocalDate date = LocalDate.of(2017, 1, 5);
        LocalDate date = LocalDate.now();

        LocalDate date1 = date.withYear(2016);
        LocalDate date2 = date.withMonth(2);
        LocalDate date3 = date.withDayOfMonth(1);
        LocalDate date4 = date.plusYears(1);
        LocalDate date5 = date.minusMonths(2);
        LocalDate date6 = date.plus(5, ChronoUnit.DAYS);

        // 返回下一个距离当前时间最近的星期日
        LocalDate date7 = date.with(nextOrSame(DayOfWeek.SUNDAY));
        // 返回本月最后一个星期六
        LocalDate date8 = date.with(lastInMonth(DayOfWeek.SATURDAY));

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date4);
        System.out.println(date5);
        System.out.println(date6);
        System.out.println(date7);
        System.out.println(date8);
    }

    private static void adjust() {
//        dayOfWeekInMonth	返回同一个月中每周的第几天
//        firstDayOfMonth	返回当月的第一天
//        firstDayOfNextMonth	返回下月的第一天
//        firstDayOfNextYear	返回下一年的第一天
//        firstDayOfYear	返回本年的第一天
//        firstInMonth	返回同一个月中第一个星期几
//        lastDayOfMonth	返回当月的最后一天
//        lastDayOfNextMonth	返回下月的最后一天
//        lastDayOfNextYear	返回下一年的最后一天
//        lastDayOfYear	返回本年的最后一天
//        lastInMonth	返回同一个月中最后一个星期几
//        next / previous	返回后一个/前一个给定的星期几
//        nextOrSame / previousOrSame	返回后一个/前一个给定的星期几，如果这个值满足条件，直接返回

//        比如给定一个日期，计算该日期的下一个工作日（不包括星期六和星期天）：
//        LocalDate date = LocalDate.of(2017, 1, 5);
        LocalDate date = LocalDate.now();

        LocalDate newDate = date.with(temporal -> {
            // 当前日期
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

            // 正常情况下，每次增加一天
            int dayToAdd = 1;

            // 如果是星期五，增加三天
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            }

            // 如果是星期六，增加两天
            if (dayOfWeek == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }

            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        System.out.println(newDate);
    }

    public static void main(String[] args) {
//        demo1();
        adjust();
    }
}
