package com.newcitysoft.study.java8.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

/**
 * @author lixin.tian@renren-inc.com
 * @date 2018/7/12 15:12
 */
public class Test {

    /**
     * 延迟初始化占位类模式
     */
    private static class TestHolder {
        public static Test test = new Test();
    }

    public static Test getTest() {
        return TestHolder.test;
    }

    private static final BlockingQueue<String> arrayQuery = new ArrayBlockingQueue<>(12);
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        ReadRunnable runnable = new ReadRunnable();
        WriteRunnable writeRunnable = new WriteRunnable();

        IntStream.range(0, 10).forEach(i -> {
            Thread thread = new Thread(runnable);
            thread.start();

            Thread writeThread = new Thread(writeRunnable);
            writeThread.start();
        });
    }

    public static class ReadRunnable implements Runnable {

        @Override
        public void run() {
            try {
                String take = queue.take();

                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class WriteRunnable implements Runnable {

        @Override
        public void run() {
            try {
                queue.put(String.valueOf(System.nanoTime()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
