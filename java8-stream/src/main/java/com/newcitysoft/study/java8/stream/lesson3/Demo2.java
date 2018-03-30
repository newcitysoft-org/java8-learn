package com.newcitysoft.study.java8.stream.lesson3;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * 将结果收集到 Map 中
 * <p>
 * Collectors.toMap
 * Function.identity()
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 14:52
 */
public class Demo2 {
    public static void main(String[] args) {
        List<Student> students = Sample.initList();

        Map<String, String> collect = students.stream()
                .collect(toMap(Student::getName, Student::getTel));
        System.out.println(collect);

        Map<String, Student> collect1 = students.stream()
                .collect(toMap(Student::getName, Function.identity()));
        System.out.println(collect1);
    }
}
