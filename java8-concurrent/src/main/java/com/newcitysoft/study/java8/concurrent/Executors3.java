package com.newcitysoft.study.java8.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * invokeAny + invokeAll
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/9 10:28
 */
public class Executors3 {
    public static void main(String[] args) throws Exception {
//        testInvokeAll();
        testInvokeAny();
    }

    /**
     * Executors支持通过invokeAll()一次批量提交多个callable。
     * 这个方法结果一个callable的集合，然后返回一个future的列表。
     */
    private static void testInvokeAll() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }).forEach(System.out::println);
    }

    /**
     * 批量提交callable的另一种方式就是invokeAny()，它的工作方式与invokeAll()稍有不同。
     * 在等待future对象的过程中，这个方法将会阻塞直到第一个callable中止然后返回这一个callable的结果。
     * @throws InterruptedException
     * @throws ExecutionException
     */
    private static void testInvokeAny() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));

        String result = executor.invokeAny(callables);
        System.out.println(result);

        executor.shutdown();
    }

    private static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

}
