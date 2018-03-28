package com.newcitysoft.study.lambda.function;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;

/**
 * IntFunction<R>, IntToDoubleFunction,
 * IntToLongFunction, LongFunction<R>,
 * LongToDoubleFunction, LongToIntFunction,
 * DoubleFunction<R>, ToIntFunction<T>,
 * ToDoubleFunction<T>, ToLongFunction<T>
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/28 15:06
 */
public class Sample {
    private static void testFunction() {
        Function<String, Integer> function = (String in) -> Integer.parseInt(in);

        System.out.println(function.apply("123"));
    }

    private static void testIntToDoubleFunction() {
        //IntToDoubleFunction function = (int num) -> (double) num;

        IntToDoubleFunction function = (int num) -> {
            num ++;
            return (double) num;
        };

        System.out.println(function.applyAsDouble(123));
    }

    private static void testIntFunction() {
        //IntFunction<String> function = (int num) -> String.valueOf(num);

        IntFunction<String> function = (int num) -> {
            num ++;
            return String.valueOf(num);
        };

        System.out.println(function.apply(123));
    }

    public static void main(String[] args) {
        testFunction();
        testIntToDoubleFunction();
        testIntFunction();
    }
}
