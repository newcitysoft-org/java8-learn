package com.newcitysoft.study.java8.stream.lesson1;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 11:01
 */
public class Demo1 {
    private static List<Student> students = Sample.initList();;
    public static void main(String[] args) {
        List<String> names = students.stream()
                .filter(s -> s.getBedroom().contains("北五"))
                .map((s) -> s.getName())
                .limit(2)
                .collect(Collectors.toList());

        names.forEach(s -> System.out.println(s));
    }
}
