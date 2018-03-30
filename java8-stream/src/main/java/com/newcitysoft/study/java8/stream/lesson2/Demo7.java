package com.newcitysoft.study.java8.stream.lesson2;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.List;
import java.util.OptionalInt;

/**
 * 数值流
 * <p>
 * IntStream、DoubleStream、LongStream
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 14:12
 */
public class Demo7 {
    public static void main(String[] args) {
        List<Student> students = Sample.initList();

        OptionalInt optionalInt = students.stream()
                .mapToInt(s -> s.getAge())
                .max();

        System.out.println("学生中年龄最大的是：" + optionalInt.getAsInt());
    }
}
