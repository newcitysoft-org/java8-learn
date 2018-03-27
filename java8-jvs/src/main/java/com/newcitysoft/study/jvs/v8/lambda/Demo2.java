package com.newcitysoft.study.jvs.v8.lambda;

import com.newcitysoft.study.jvs.v8.fi.Converter;

/**
 * 七、访问对象字段与静态变量
 * @author Administrator
 *
 */
public class Demo2 {
    static int outerStaticNum;
    int outerNum;
    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        System.out.println(stringConverter1.convert(2));


        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
        System.out.println(stringConverter2.convert(3));
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.testScopes();
        System.out.println(outerStaticNum+demo2.outerNum);
    }

}
