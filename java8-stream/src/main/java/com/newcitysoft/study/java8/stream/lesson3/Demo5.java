package com.newcitysoft.study.java8.stream.lesson3;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

/**
 * 转换类型
 * <p>
 * Collectors.toCollection
 * <p>
 * Collectors.collectingAndThen
 * <p>
 * Collectors.maxBy
 * <p>
 * Collectors.minBy
 * <p>
 * 按照性别筛选出每组年龄最高的学生
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/2 10:37
 */
public class Demo5 {

    public static void main(String[] args) {
        List<Student> students = Sample.initList();

        Collection<Student> collect = students.stream().collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        System.out.println(collect);

        Map<String, Student> collect1 = students.stream()
                .collect(groupingBy(s -> s.getGender().name(), collectingAndThen(
                        maxBy(Comparator.comparingInt(Student::getAge)),
                        Optional::get
                )));
        System.out.println(collect1);

    }
}
