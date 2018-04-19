package com.newcitysoft.study.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.newcitysoft.study.java8.completablefuture.Demo9.m1;
import static com.newcitysoft.study.java8.completablefuture.Demo9.m2;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/19 17:30
 */
public class Demo10 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture.anyOf(m1(), m2())
                .thenRun(() -> {
                    System.out.println(System.currentTimeMillis() - start);
                }).get();
    }
}
