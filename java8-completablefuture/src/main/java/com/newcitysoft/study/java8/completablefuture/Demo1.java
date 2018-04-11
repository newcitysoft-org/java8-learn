package com.newcitysoft.study.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * CompletableFuture 对象的创建
 * 四个静态方法用来为一段异步执行的代码创建 CompletableFuture 对象
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/11 11:02
 */
public class Demo1 {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        IntStream.range(0, 20)
                .forEach(i -> {
                    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println("Hello CompletableFuture :" + i), executorService);

                    CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> 2333, executorService);
                    try {
                        System.out.println(integerCompletableFuture.get() + ":" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });

    }
}
