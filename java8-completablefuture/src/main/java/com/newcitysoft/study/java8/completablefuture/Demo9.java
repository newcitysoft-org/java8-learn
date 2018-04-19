package com.newcitysoft.study.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/19 17:28
 */
public class Demo9 {

    public static CompletableFuture<Integer> m1(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m1");
            return 2333;
        });
    }

    public static CompletableFuture<Integer> m2(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m2");
            return 8877;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        m1().acceptEither(m2(), t -> {
            System.out.println("t = " + t);
        }).get();
    }
}
