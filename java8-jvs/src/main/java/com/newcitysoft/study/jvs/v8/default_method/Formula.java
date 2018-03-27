package com.newcitysoft.study.jvs.v8.default_method;

/**
 * Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法。
 * 在Java中只有单继承，如果要让一个类赋予新的特性，
 * 通常是使用接口来实现，在C++中支持多继承，
 * 允许一个子类同时具有多个父类的接口与功能，
 * 在其他语言中，让一个类同时具有其他的可复用代码的方法叫做mixin。
 * 新的Java 8 的这个特新在编译器实现的角度上来说更加接近Scala的trait。
 * 在C#中也有名为扩展方法的概念，允许给已存在的类型扩展方法，和Java 8的这个在语义上有差别。
 * @author newcitysoft@163.com
 * @date 2018-01-26 13:27
 */
public interface Formula {
	double calculate(int a);
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
