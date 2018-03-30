package com.newcitysoft.study.java8.stream.lesson2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 扁平流
 * flatMap
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 11:32
 */
public class Demo4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("I am a boy", "I love the girl", "But the girl loves another girl");

        list.stream()
                .map(word -> word.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
                .forEach(word -> System.out.println(word));


//        list.stream()
//                .map(word -> word.replace(" ", ""))
//                .flatMap(word -> {
//                    byte[] chars = word.getBytes();
//                    System.out.println(chars);
//                    return Stream.of(chars);
//                })
//                .distinct()
//                .forEach(chars -> System.out.println(chars));

    }
}
