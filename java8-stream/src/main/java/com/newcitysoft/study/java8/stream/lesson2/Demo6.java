package com.newcitysoft.study.java8.stream.lesson2;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Gender;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.Arrays;
import java.util.List;

/**
 /**
 * 归约（reduce）
 * <p>
 * 1.元素求和
 * 2.学生学号规约
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 14:03
 */
public class Demo6 {
    public static void main(String[] args) {
        // 1.元素求和
        List<Integer> nums = Arrays.asList(1,2,1,5,1,9,10);
        System.out.println(nums.stream().reduce((a, b) -> a + b).get());
        // 2.所有女同学的学号进行规约
        List<Student> students = Sample.initList();
        String stuIds = students.stream()
                .filter(s -> s.getGender() == Gender.FEMALE)
                .map(Student::getStuId)
                .reduce((s1, s2) -> s1 + " " + s2)
                .get();
        System.out.println(stuIds);


    }
}
