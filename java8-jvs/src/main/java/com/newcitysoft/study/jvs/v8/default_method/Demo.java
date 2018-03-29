package com.newcitysoft.study.jvs.v8.default_method;

import org.junit.Test;

import static java.lang.Math.sqrt;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018-03-29 11:21
 */
public class Demo {

	@Test
	public void test() {
		Formula formula = a -> sqrt(a * 100);

		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16));
	}
}
