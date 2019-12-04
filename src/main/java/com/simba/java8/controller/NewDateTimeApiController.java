package com.simba.java8.controller;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * 1.8中增加新的日期api
 * 	相比原来的时间API，
 * 	java.util.Date存在的问题：
 * 		1、线程不安全，所有的日期类都是可变的
 * 		2、设计差，日期类和时间类的定义不一致，在java.util和java.sql中都有日期类，
 * 			java.util.data中包含日期和时间，java.sql.data中只包含日期
 * 		3、Data类没有提供国际化，时区，需要单独使用java.util.calender和java.util.timezone来实现
 * 	1.8之后的改进：
 * 		1、新的日期加入到了java.time类中
 * 		2、主要使用的两个API是：Local，zoned
 *
 */
public class NewDateTimeApiController {

	@Test
	public void newDate(){
		//获取当前的时间
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		//获取当前的时间戳
		System.out.println(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
		//时间戳转为localDateTime
		long timestamp = 1575374801690L;
		Instant instant = Instant.ofEpochMilli(timestamp);
		LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, ZoneId.of("+8"));
		System.out.println(localDateTime1);
		//获取两个小时之前的时间
		LocalDateTime localDateTime2 = localDateTime1.minusHours(2);
		System.out.println(localDateTime2);
		//获取某个固定时区的时间
		LocalDateTime localDateTime3 = LocalDateTime.now(ZoneId.of("+9"));
		System.out.println(localDateTime3);

	}
}
