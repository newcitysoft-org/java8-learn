package com.newcitysoft.study.java8.defaultmethods;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/29 11:04
 */
public interface Animal {
    void eat();
    void sleep();
    void run();

    default void call() {
        System.out.println("动物再叫！");
    }

    static Animal getInstance() {
        return new Dog();
    }
}
