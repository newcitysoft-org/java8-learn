package com.newcitysoft.study.lambda.other;

import com.newcitysoft.study.lambda.entity.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * 方法引用
 * <p>
 * 1. 指向静态方法的方法引用
 * 2. 指向现有对象的实例方法的方法引用
 *
 * @author biezhi
 * @date 2018/2/10
 */
public class MethodReference {

    public static List<Integer> findNumbers(List<Integer> numbers, Predicate<Integer> filter) {
        List<Integer> numbersFound = numbers
                .stream()
                .filter(filter)
                .collect(toList());

        return numbersFound;
    }

    public static boolean multipleOf3(Integer number) {
        return (number % 3) == 0;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 6, 8, 9, 12, 14, 15);

        List<Integer> multiplesOf3 = findNumbers(numbers, MethodReference::multipleOf3);
        System.out.println(Arrays.toString(multiplesOf3.toArray()));
        System.out.println(multiplesOf3.contains(3));

        Student student = Student.builder().name("Blade").build();
        Student student2 = Student.builder().name("Acice").build();
        Student student3 = Student.builder().name("Bob").build();

        List<Student> students = Arrays.asList(student, student2, student3);

        long count = students.stream()
                .map(Student::getName)
                .count();
        System.out.println(count);

        String collection = students.stream().map(Student::getName).reduce((s1, s2) -> s1 + " " + s2).get();
        System.out.println(collection);

    }

}
