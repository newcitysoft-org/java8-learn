package com.newcitysoft.study.java8.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 12:39
 */
public class DurationDemo {

    public static void main(String[] args) throws InterruptedException {
        Instant first = Instant.now();
        TimeUnit.SECONDS.sleep(5);
        Instant end = Instant.now();
        Duration duration = Duration.between(first, end);

        long seconds = duration.getSeconds();

        System.out.println("相差：" + seconds + "秒");

        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.plusDays(5);
        Duration duration1 = Duration.between(from, to);

        System.out.println("相差：" + duration1.toDays() +"天");

    }
}
