package com.simba.java8.controller;

import org.junit.Test;

import java.util.Optional;

/**
 * optional java8新引入的类，用来解决指针异常
 * 该类是一个可以为null的容器对象，
 */
public class OptionalController {

	@Test
	public void test(){
		String str1 = null;
		String str2 = "s";
		Optional<String> optional = Optional.ofNullable(str1);
		//使用of方法，传入一个null进去会报空指针异常
//		Optional<String> optional2 = Optional.of(str1);
		Optional<String> optional2 = Optional.of(str2);
		System.out.println(optional);
		System.out.println(optional2);
		System.out.println(optional.isPresent());
//		String s = optional.get();
		String s2 = optional2.get();
//		System.out.println(s);
		System.out.println(s2);

	}
}
