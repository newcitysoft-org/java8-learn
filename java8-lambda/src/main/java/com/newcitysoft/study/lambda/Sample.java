package com.newcitysoft.study.lambda;

import com.newcitysoft.study.lambda.entity.Gender;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/28 13:57
 */
public class Sample {

    private static List<Student> filter(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(toList());
    }

    public static List<Student> initList() {
        List<Student> students = new ArrayList<>();

        students.add(Student.builder().stuId("120402033").name("tianlixin").age(26)
                .bedroom("323").major("软件工程").gender(Gender.MALE).tel("15841694657").build());

        students.add(Student.builder().stuId("120402055").name("xiaohaun").age(25)
                .bedroom("623").major("软件工程").gender(Gender.FEMALE).tel("15841694612").build());

        students.add(Student.builder().stuId("120403045").name("yongxiaoxu").age(26)
                .bedroom("456").major("运输经济").gender(Gender.FEMALE).tel("15841694612").build());

        return students;
    }

    public static void testRunnable() {
        Runnable task = () -> System.out.println("这是个多线程任务！");

        Thread thread = new Thread(task);
        thread.start();
    }

    public static void main(String[] args) {
        Predicate<Student> predicate = (Student student) -> student.getAge() >= 26;
        List<Student> list = filter(initList(), predicate);
        list.forEach(student -> System.out.println(student.toString()));

        Predicate<Student> femalePredicate = (Student student) -> student.getGender() == Gender.FEMALE;
        list = filter(list, femalePredicate);
        list.forEach(student -> System.out.println(student.toString()));

        testRunnable();
    }
}
