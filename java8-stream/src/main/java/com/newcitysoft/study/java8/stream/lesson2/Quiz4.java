package com.newcitysoft.study.java8.stream.lesson2;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.List;

/**
 * 计算软件工程的年纪平均值
 * @author biezhi
 * @date 2018/2/12
 */
public class Quiz4 {

    public static void main(String[] args) {

        List<Student> students = Sample.initList();
        Integer averAge = students.stream()
                .filter(s -> s.getMajor().equals("软件工程"))
                .map(s -> s.getAge())
                .reduce((s1, s2) -> (s1 + s2) / 2)
                .get();
        System.out.println(averAge);
    }

}