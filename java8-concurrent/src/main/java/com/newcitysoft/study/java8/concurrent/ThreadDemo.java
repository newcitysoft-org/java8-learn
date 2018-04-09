package com.newcitysoft.study.java8.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/9 9:57
 */
public class ThreadDemo {

    private static void test1() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }

    private static void test2() {
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
