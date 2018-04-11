package com.newcitysoft.study.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 计算结果完成时的处理
 *<pre>
 *  当 CompletableFuture 的计算结果完成，或者抛出异常的时候，我们可以执行特定的 Action。
 * CompletableFuture<T> whenComplete(BiConsumer<? super T,? super Throwable> action)
 * CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T,? super Throwable> action)
 * CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T,? super Throwable> action, Executor executor)
 * CompletableFuture<T> exceptionally(Function<Throwable,? extends T> fn)
 * 同时进行计算和转换
 * <U> CompletableFuture<U> handle(BiFunction<? super T,Throwable,? extends U> fn)
 * <U> CompletableFuture<U> handleAsync(BiFunction<? super T,Throwable,? extends U> fn)
 * <U> CompletableFuture<U> handleAsync(BiFunction<? super T,Throwable,? extends U> fn, Executor executor)
 * </pre>
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/11 11:14
 */
public class Demo2 {

    public static void main(String[] args) {
        CompletableFuture<Integer> uCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("开始执行运算");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int a = 1/0;
            System.out.println("执行结束");
            return 2333;
        });

        try {
            Integer result = uCompletableFuture.whenComplete((a, b) -> {
                System.out.println("Result: " + a);
                System.out.println("Exception: " + b);
            }).exceptionally(e -> {
                System.out.println(e.getMessage());
                return 666;
            }).get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
