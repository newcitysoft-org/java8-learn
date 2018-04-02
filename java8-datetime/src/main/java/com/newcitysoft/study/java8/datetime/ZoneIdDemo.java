package com.newcitysoft.study.java8.datetime;

import java.time.ZoneId;
import java.util.TimeZone;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 11:00
 */
public class ZoneIdDemo {

    public static void main(String[] args) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");

        ZoneId oldZoneId = TimeZone.getDefault().toZoneId();

        System.out.println(defaultZoneId);
        System.out.println(shanghaiZoneId);
        System.out.println(oldZoneId);

        System.out.println("-----------------");

        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(zoneId -> zoneId.contains("Asia"))
                .sorted()
                .forEach(zoneId -> System.out.println(zoneId));
    }
}
