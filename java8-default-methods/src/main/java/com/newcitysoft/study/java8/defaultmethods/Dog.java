package com.newcitysoft.study.java8.defaultmethods;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/29 11:05
 */
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("狗吃饭！");
    }

    @Override
    public void sleep() {
        System.out.println("狗睡觉！");
    }

    @Override
    public void run() {
        System.out.println("狗跑步！");
    }
}
