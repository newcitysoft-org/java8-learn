package com.newcitysoft.study.lambda.supplier;

import com.newcitysoft.study.lambda.entity.Gender;
import com.newcitysoft.study.lambda.entity.Student;

import java.util.function.Supplier;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/28 15:26
 */
public class Sample {
    public static void testSupplier() {
        Supplier<Student> supplier = () -> Student.builder().age(26).name("tianlixin")
                .gender(Gender.MALE).major("软件工程").stuId("120402033").tel("15841694657").build();

        System.out.println(supplier.get().toString());
    }

    public static void main(String[] args) {
        testSupplier();
    }
}
