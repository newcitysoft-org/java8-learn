package com.newcitysoft.study.java8.defaultmethods;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/3/29 11:08
 */
public class Sample {
    public static void main(String[] args) {
        Animal dog = AnimalFactory.getInstance();

        dog.eat();
        dog.sleep();
        dog.run();
        dog.call();

        Animal dog2 = Animal.getInstance();

        dog2.eat();
        dog2.sleep();
        dog2.run();
        dog2.call();
    }
}
