package com.newcitysoft.study.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 当两个 CompletionStage 都正常完成计算的时候,执行一个 Runnable
 * <U> CompletableFuture<Void> thenAcceptBoth(CompletionStage<? extends U> other, BiConsumer<? super T,? super U> action)
 * <U> CompletableFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T,? super U> action)
 * <U> CompletableFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T,? super U> action, Executor executor)
 * CompletableFuture<Void> runAfterBoth(CompletionStage<?> other,  Runnable action)
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/19 15:45
 */
public class Demo6 {

    public static void main(String[] args) {
        try {
            CompletableFuture.supplyAsync(() -> 5566)
                    .thenAcceptBothAsync(CompletableFuture.supplyAsync(() -> "7788"), (a, b) -> {
                        System.out.println(a);
                        System.out.println(b);
                    }).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
