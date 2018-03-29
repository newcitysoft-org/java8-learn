package com.newcitysoft.study.java8.defaultmethods;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/29 11:08
 */
public class AnimalFactory {
    public static Animal getInstance() {
        return new Dog();
    }
}
