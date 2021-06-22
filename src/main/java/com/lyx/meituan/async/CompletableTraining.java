package com.lyx.meituan.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author lvyunxiao
 * @date 2021/3/10
 * @description
 */
public class CompletableTraining {

    public static void main(String[] args) {

        sync();

        async();

        System.out.println("All finished!");
    }

    public static void async() {
        final long start = System.currentTimeMillis();
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("async cf1 finished!");
            return "cf1";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("async cf2 finished!");
            return "cf2";
        });

        try {
            CompletableFuture.allOf(cf1, cf2).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // System.out.println("cf1: " + cf1.isDone() + " cf12: " + cf2.isDone());
        System.out.println("async cost time (ms): " + (System.currentTimeMillis() - start));

    }

    public static void sync() {
        final long start = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sync cf1 finished!");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sync cf2 finished!");
        System.out.println("sync cost time (ms): " + (System.currentTimeMillis() - start));

    }

}
