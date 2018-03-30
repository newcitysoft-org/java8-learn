package com.newcitysoft.study.java8.stream.lesson2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 创建流
 * Stream.of
 * Arrays.stream
 * collection.stream
 * Files.lines
 * Stream.iterate
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 11:12
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob");

        Stream<String> nameStream = names.stream();

        Stream<String> animalStream = Arrays.stream(new String[]{"Dog", "Cat", "Duke"});

        Stream<Integer> ageStream = Stream.of(20,25,26);
    }
}
