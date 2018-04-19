package com.newcitysoft.study.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 扁平转换
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/11 11:50
 */
public class Demo4 {

    public static void main(String[] args) {
        try {
            String test = CompletableFuture.supplyAsync(() -> 666)
                    .thenCompose(t -> CompletableFuture.supplyAsync(() -> t + " hello!"))
                    .get();
            System.out.println(test);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
