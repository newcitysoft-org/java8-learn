package com.newcitysoft.study.java8.datetime;

import java.time.LocalTime;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 11:42
 */
public class LocalTimeDemo {

    public static void main(String[] args) {
        // 创建
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(21, 20, 20);
        // 访问方法
        System.out.println(localTime.getHour());
        // 计算
        System.out.println(localTime.plusHours(5));
    }
}
