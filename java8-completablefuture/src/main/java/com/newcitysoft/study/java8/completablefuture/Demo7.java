package com.newcitysoft.study.java8.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * 对上一步的计算结果不关心，执行下一个操作
 * CompletableFuture<Void> thenRun(Runnable action)
 * CompletableFuture<Void> thenRunAsync(Runnable action)
 * CompletableFuture<Void> thenRunAsync(Runnable action, Executor executor)
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/19 16:51
 */
public class Demo7 {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> 1234)
                .thenRun(System.out::println);
    }
}
