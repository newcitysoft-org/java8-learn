package com.newcitysoft.study.jvs.v8.fi;

/**
 * 每一个lambda表达式都对应一个类型，通常是接口类型。
 * 而“函数式接口”是指仅仅只包含一个抽象方法的接口，每一个该类型的lambda表达式都会被匹配到这个抽象方法。
 * 因为 默认方法 不算抽象方法，所以也可给函数式接口添加默认方法。
 * @author newcitysoft@163.com
 * @date 2018-01-26 13:59
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
public interface Converter<F, T> {
	T convert(F from);

	default void print(T t){
		System.out.println(t);
	}
}


