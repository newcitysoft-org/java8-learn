package com.newcitysoft.study.lambda.consumer;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * IntConsumer,LongConsumer, DoubleConsumer
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/28 15:19
 */
public class Sample {
    private static void testConsumer() {
        Consumer<Integer> consumer = (Integer num) -> System.out.println(num);
        consumer.accept(2);
    }

    private static void testIntConsumer() {
        IntConsumer consumer = (int num) -> {
            System.out.println(String.format("半径为%s的圆的周长为：%s", num, 2 * Math.PI * num));
        };

        consumer.accept(5);
    }

    public static void main(String[] args) {
        testConsumer();
        testIntConsumer();
    }
}
