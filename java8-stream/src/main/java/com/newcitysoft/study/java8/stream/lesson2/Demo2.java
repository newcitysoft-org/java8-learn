package com.newcitysoft.study.java8.stream.lesson2;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Gender;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 筛选元素
 *
 * filter 使用
 * distinct 使用
 * limit 使用
 * skip 使用
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 11:16
 */
public class Demo2 {
    public static void main(String[] args) {
        List<Student> students = Sample.initList();
        students.stream().filter(s -> s.getGender() == Gender.FEMALE)
                .collect(Collectors.toList())
                .forEach(s -> System.out.println(s.toString()));
        System.out.println("----------------");
        Stream<Integer> nums = Stream.of(1,2,1,6,4,2,1,2);
        nums.distinct().limit(2)
                .collect(Collectors.toList())
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
        Stream.of(1,2,1,6,4,2,1,2)
                .skip(4)
                .collect(Collectors.toList())
                .forEach(i -> System.out.print(i + " "));

    }

}
