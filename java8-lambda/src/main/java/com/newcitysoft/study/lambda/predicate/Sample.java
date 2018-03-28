package com.newcitysoft.study.lambda.predicate;

import com.newcitysoft.study.lambda.entity.Student;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/28 14:41
 */
public class Sample {
    public static void testPridicate() {
        Predicate<Student> childPredicate = (Student student) -> student.getAge() < 16;

        Student alice = Student.builder().age(15).name("Alice").build();
        System.out.println(alice.getName() + " is child? " + childPredicate.test(alice));

        Student bob = Student.builder().age(16).name("Bob").build();
        System.out.println(bob.getName() + " is child? " + childPredicate.test(bob));
    }

    public static void testIntPredicate() {
        IntPredicate intPredicate = (int num) -> num >= 15;
        IntPredicate intPredicate2 = (int num) -> num < 20;

        System.out.println(intPredicate.and(intPredicate2).test(21));
    }

    public static void testLongPredicate() {
        LongPredicate longPredicate = (long time) -> time < System.currentTimeMillis();

        System.out.println(longPredicate.test(1522220523915L));
     }

     public static void testDoublePredicate() {
         DoublePredicate doublePredicate = (double dou) -> dou < 12.56;
     }

    public static void main(String[] args) {
        testPridicate();
        System.out.println("----------------");
        testIntPredicate();
        System.out.println("----------------");
        testLongPredicate();
        System.out.println("----------------");

//        System.out.println(System.currentTimeMillis());
    }
}
