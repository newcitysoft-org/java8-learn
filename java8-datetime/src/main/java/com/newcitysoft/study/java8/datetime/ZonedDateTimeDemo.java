package com.newcitysoft.study.java8.datetime;

import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 11:53
 */
public class ZonedDateTimeDemo {

    public static void main(String[] args) {
        // 1.创建一个ZonedDateTime实例
        ZonedDateTime dateTime = ZonedDateTime.now();
        // 另一种方式是使用指定的年月日、时分秒、纳秒以及时区ID来新建对象：
        ZoneId zoneId = ZoneId.of("UTC+1");
        ZonedDateTime dateTime1 = ZonedDateTime.of(2018,4,2,11,54,20,1234,zoneId);
        // 2.访问ZonedDateTime对象的时间
        System.out.println(dateTime.getDayOfMonth());
        // 3.计算
        System.out.println(dateTime.plusDays(2));
        // 4.但注意计算时，若不巧跨越了夏令时（会补一小时或减一小时），
        // 可能得不到希望的结果。一个替代的正确做法是使用Period：
        ZonedDateTime newZonedDateTime = dateTime.plus(Period.ofDays(2));
        System.out.println(newZonedDateTime);
    }
}
