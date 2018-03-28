package com.newcitysoft.study.lambda.other;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/28 15:48
 */
public class Sample {
    /**
     * 构造器引用
     * 根据参数列表自动匹配构造器
     */
    private static void testConstructorReference() {
        Supplier<Sample> supplier = Sample::new;
        System.out.println(supplier.get());
    }

    private static void test() {
        Function<String, Integer> stringToInteger = s -> Integer.parseInt(s);
        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);

        System.out.println(stringToInteger.apply("12321"));
        System.out.println(contains.test(Arrays.asList("adb", "qwe", "asdas", "aaa", "bb"), "aaa"));
    }

    public static void main(String[] args) {
        testConstructorReference();
        test();
    }
}
