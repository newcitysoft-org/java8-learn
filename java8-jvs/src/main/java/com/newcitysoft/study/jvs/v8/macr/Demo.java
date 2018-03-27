package com.newcitysoft.study.jvs.v8.macr;

import com.newcitysoft.study.jvs.v8.fi.Converter;

/**
 * 四、方法与构造函数引用
 * @author newcitysoft@163.com
 *
 */
public class Demo {
	public static void constructorReference(){
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker", 20);
		System.out.println(person.toString());

	}

	public static void main(String[] args) {
		//Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用，上面的代码展示了如何引用一个静态方法
		Converter<String, Integer> converter = Integer::valueOf;

		Integer converted = converter.convert("123");
		System.out.println(converted);   // 123

		constructorReference();
	}
}
