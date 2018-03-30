package com.newcitysoft.study.java8.stream.lesson3;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Gender;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

/**
 * 数据分区
 * <p>
 * Collectors.partitioningBy
 * <p>
 * 根据前后端将项目分为两组
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/30 15:08
 */
public class Demo4 {

    public static boolean isMale(Student student) {
        return Gender.MALE == student.getGender();
    }

    public static void main(String[] args) {
        List<Student> students = Sample.initList();

        Map<Boolean, List<Student>> collect = students
                .stream()
                .collect(partitioningBy(Demo4::isMale));

        System.out.println(collect);
    }
}
