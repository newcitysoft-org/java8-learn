package com.newcitysoft.study.java8.stream.lesson3;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * 分组
 * <p>
 * Collectors.groupingBy
 * <p>
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 14:57
 */
public class Demo3 {
    public static void main(String[] args) {
        List<Student> projects = Sample.initList();
        Map<String, List<Student>> collect = projects.stream()
                .collect(groupingBy(Student::getMajor));
        System.out.println(collect);

    }
}
