package com.newcitysoft.study.jvs.v8.date;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class Demo1 {

	/**
	 * Clock 时钟
	 * Clock类提供了访问当前日期和时间的方法，
	 * Clock是时区敏感的，
	 * 可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。
	 * 某一个特定的时间点也可以使用Instant类来表示，Instant类也可以用来创建老的java.util.Date对象。
	 */
	public static void testClock(){
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);   // legacy java.util.Date
	}

	/**
	 * Timezones 时区
	 * 在新API中时区使用ZoneId来表示。
	 * 时区可以很方便的使用静态方法of来获取到。
	 * 时区定义了到UTS时间的时间差，在Instant时间点对象到本地日期对象之间转换的时候是极其重要的。
	 */
	public static void testTimezones(){
		System.out.println(ZoneId.getAvailableZoneIds());
		// prints all available timezone ids
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());
		// ZoneRules[currentStandardOffset=+01:00]
		// ZoneRules[currentStandardOffset=-03:00]
	}

	public static void main(String[] args) {
		testTimezones();
	}
}
