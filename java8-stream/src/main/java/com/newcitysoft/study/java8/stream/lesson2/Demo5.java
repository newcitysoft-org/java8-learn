package com.newcitysoft.study.java8.stream.lesson2;

import com.alibaba.fastjson.JSONObject;
import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Gender;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.List;

/**
 * 匹配元素
 * <p>
 * allMatch 使用
 * anyMatch 使用
 * noneMatch 使用
 * findFirst 使用
 * findAny 使用
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 13:53
 */
public class Demo5 {
    public static void main(String[] args) {
        List<Student> students = Sample.initList();

        students.forEach(s -> System.out.println(s));

        System.out.println(students.stream().anyMatch(s -> s.getAge() == 26));
        System.out.println(students.stream().allMatch(s -> s.getGender() == Gender.FEMALE));
        System.out.println(students.stream().noneMatch(s -> s.getMajor().equals("软件工程")));

        System.out.println(students.stream().findAny().get());
        System.out.println(students.stream().findFirst().get());

    }
}
