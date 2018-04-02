package com.newcitysoft.study.java8.datetime;

import java.time.Instant;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 11:12
 */
public class InstantDemo {

    public static void main(String[] args) {
        // 创建Instant实例
        Instant instant = Instant.now();
        // 获取秒和纳秒
        long second = instant.getEpochSecond();
        long nano = instant.getNano();

        System.out.println(second);
        System.out.println(nano);
        System.out.println(instant);

        // Instant的计算
        Instant instant1 = instant.plusSeconds(50);
        System.out.println(instant1);

    }
}
