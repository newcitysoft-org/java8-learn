package com.newcitysoft.study.java8.datetime;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.TimeZone;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 11:00
 */
public class ZoneIdDemo {

    public static void main(String[] args) {
        // 获取系统默认时区
        ZoneId defaultZoneId = ZoneId.systemDefault();
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        // 老时区
        ZoneId oldZoneId = TimeZone.getDefault().toZoneId();

        System.out.println(defaultZoneId);
        System.out.println(shanghaiZoneId);
        System.out.println(oldZoneId);

        System.out.println("-----------------");
        // 获取可用时区集合
        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(zoneId -> zoneId.contains("Asia"))
                .sorted()
                .forEach(zoneId -> System.out.println(zoneId));

        System.out.println("将一个 LocalDate、LocalTime 或 LocalDateTime 对象转化为 ZonedDateTime 对象");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, shanghaiZoneId);
        System.out.println(zonedDateTime);
        System.out.println("以当前时间和 世界标准时间（UTC）/格林威治时间（GMT） 的偏差来计算");
        ZoneOffset zoneOffset = ZoneOffset.of("+09:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
        System.out.println(offsetDateTime);
    }
}
