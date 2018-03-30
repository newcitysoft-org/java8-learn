package com.newcitysoft.study.java8.stream.lesson2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 映射
 * map 使用
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 11:25
 */
public class Demo3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");

        words.stream()
                .map(word -> word.substring(0,1))
                .collect(Collectors.toList())
                .forEach(word -> System.out.println(word));
    }
}
