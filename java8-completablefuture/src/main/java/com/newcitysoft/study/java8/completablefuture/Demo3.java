package com.newcitysoft.study.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 结果转换(map)
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/11 11:20
 */
public class Demo3 {

    public static void main(String[] args) {
        try {
            String result = CompletableFuture.supplyAsync(() -> 22333)
                    .thenApplyAsync(String::valueOf).get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
