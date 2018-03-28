package com.newcitysoft.study.lambda.other;

import com.newcitysoft.study.lambda.Sample;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * lambdas
 *
 * @author biezhi
 * @date 2018/2/10
 */
public class Lambdas {

    public static void main(String[] args) {
        List<Student> students = Sample.initList();
        List<String>  names = getNames(students, student -> student.getAge() > 25, student -> student.getBedroom());
        System.out.println(names);
        List<Integer> ages = getNames(students, student -> student.getAge() > 25, ProjectFunction.buildAgeFunction());
        System.out.println(ages);
//        names.forEach(name -> System.out.println(name));
    }

    public static List<String> getNames(List<Student> projects) {
        List<String> names = new ArrayList<>();
        for (Student project : projects) {
            names.add(project.getName());
        }
        return names;
    }

    public static List<String> getNames(List<Student> students, Predicate<Student> predicate) {
        List<String> names = new ArrayList<>();
        for (Student project : students) {
            if (predicate.test(project)) {
                names.add(project.getName());
            }
        }
        return names;
    }

    public static <R> List<R> getNames(List<Student> students, Predicate<Student> predicate, Function<Student, R> function) {
        List<R> names = new ArrayList<>();
        for (Student project : students) {
            if (predicate.test(project)) {
                names.add(function.apply(project));
            }
        }
        return names;
    }

}

interface ProjectFunction<R> extends Function<Student, R> {

    static ProjectFunction<Integer> buildAgeFunction() {
        return Student::getAge;
    }

}