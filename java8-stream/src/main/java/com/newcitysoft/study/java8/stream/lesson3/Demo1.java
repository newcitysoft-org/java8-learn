package com.newcitysoft.study.java8.stream.lesson3;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingInt;

/**
 * 1. 计数
 * <p>
 * Collectors.counting
 * count
 * <p>
 * 2. 最值
 * Collectors.maxBy
 * <p>
 * 3. 求和
 * Collectors.summingInt
 * <p>
 * 4. 求平均值
 * Collectors.averagingInt
 * <p>
 * 5. 连接字符串
 * Collectors.joining
 * <p>
 * 6. 一般归约
 * Collectors.reducing
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 14:37
 */
public class Demo1 {
    public static void main(String[] args) {
        List<Student> students = Sample.initList();

        // 平均值
        Double collect = students.stream().collect(averagingInt(Student::getAge));
        System.out.println(collect);
        // 连接字符串
        System.out.println(Stream.of("Hello", "Java8")
                .collect(joining(",")));
        // 一般归约
        Integer collect1 = students.stream()
                .collect(reducing(0, Student::getAge, (x, y) -> x + y));
        System.out.println(collect1);
        // 一般归约
        Optional<String> collect2 = students.stream()
                .map(Student::getName)
                .collect(reducing((x, y) -> x + " " + y));
        System.out.println(collect2.get());
        //求和
        Integer sum = students.stream()
                .collect(summingInt(Student::getAge));
        System.out.println(sum);
        //最值
        Integer max = students.stream()
                .mapToInt(Student::getAge)
                .max().getAsInt();
        System.out.println(max);
    }
}
