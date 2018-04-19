package com.newcitysoft.study.java8.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * 消耗结果
 * @author lixin.tian@renren-inc.com
 * @date 2018/4/19 15:39
 */
public class Demo5 {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> 5566)
                .thenAccept(System.out::println);
    }
}
