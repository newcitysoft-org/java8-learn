package com.newcitysoft.study.jvs.v8.fi;

public class Demo {
	public static void main(String[] args) {
		Converter<String, Integer> converter = (from) -> Integer.parseInt(from);
		
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
		
		converter.print(123);
		
		Converter<String, Integer> converter2 = (from) -> Integer.parseInt(from) + 20;
		
		Integer converted2 = converter2.convert("123");
		System.out.println(converted2);    // 123
		
	}
}
