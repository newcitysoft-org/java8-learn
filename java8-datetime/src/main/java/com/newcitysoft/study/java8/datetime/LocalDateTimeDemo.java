package com.newcitysoft.study.java8.datetime;

import java.time.LocalDateTime;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 11:46
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        System.out.println(dateTime.getHour());

        System.out.println(dateTime.plusDays(5));
    }
}
