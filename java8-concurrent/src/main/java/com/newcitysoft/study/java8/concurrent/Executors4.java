package com.newcitysoft.study.java8.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/9 10:41
 */
public class Executors4 {

    public static void main(String[] args) throws InterruptedException {
//        testScheduledExecutor();
//        testScheduleAtFixedRate();
        testScheduleWithFixedDelay();
    }

    /**
     * 为了持续的多次执行常见的任务，可以利用调度线程池。
     * ScheduledExecutorService支持任务调度，持续执行或者延迟一段时间后执行。
     * @throws InterruptedException
     */
    private static void testScheduledExecutor() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);
    }

    /**
     * 用来以固定频率来执行一个任务
     */
    private static void testScheduleAtFixedRate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());

        int initialDelay = 0;
        int period = 1;

        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }

    /**
     * 这个方法的工作方式与上面描述的类似。
     * 不同之处在于等待时间 period 的应用是在一次任务的结束和下一个任务的开始之间。
     */
    private static void testScheduleWithFixedDelay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling：" + System.nanoTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }
}
