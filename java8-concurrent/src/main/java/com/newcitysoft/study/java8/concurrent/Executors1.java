package com.newcitysoft.study.java8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Executor的使用
 * ExecutorService.submit方法 + 延迟停止（等待线程池中的任务执行结束）
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/9 10:04
 */
public class Executors1 {

    public static void main(String[] args) {
        test1(3);
    }

    private static void test1(long seconds) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(seconds);
                String name = Thread.currentThread().getName();
                System.out.println("task finished: " + name);
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        });

        executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(seconds * 2);
                String name = Thread.currentThread().getName();
                System.out.println("task finished: " + name);
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        });

        stop(executor);
    }

    /**
     * 延迟停止某线程池
     * 等待5秒，5秒后强制停止正在执行的任务。
     *
     * @param executor
     */
    static void stop(ExecutorService executor) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }
}
