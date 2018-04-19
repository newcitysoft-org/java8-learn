package com.newcitysoft.study.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 组合
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/19 16:57
 */
public class Demo8 {

    public static void main(String[] args) {
        try {
            String future = CompletableFuture.supplyAsync(() -> 5566)
                    .thenCombine(CompletableFuture.supplyAsync(() -> "78913123"), (a, b) -> {
                        System.out.println(a);
                        System.out.println(b);
                        return a + b;
                    }).get();
            System.out.println(future);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
