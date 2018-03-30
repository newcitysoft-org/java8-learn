package com.newcitysoft.study.java8.stream.lesson2;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. 你将如何利用流来筛选前两个Java项目呢？
 * <p>
 *
 * @author biezhi
 * @date 2018/2/12
 */
public class Quiz2 {

    public static void main(String[] args) {
        List<Student> projects = Sample.initList();

        System.out.println(projects.stream().map(Student::getName).limit(2).collect(Collectors.toList()));
    }

}
