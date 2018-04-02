package com.newcitysoft.study.java8.datetime;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * Clock类提供了访问当前日期和时间的方法，Clock是时区敏感的，可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。
 * 某一个特定的时间点也可以使用Instant类来表示，Instant 类也可以用来创建老的 java.util.Date 对象。
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 11:25
 */
public class ClockDemo {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);
        Instant instant = clock.instant();
        // legacy java.util.Date
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);
    }
}
