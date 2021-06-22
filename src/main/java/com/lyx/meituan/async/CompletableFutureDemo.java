package com.lyx.meituan.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author lvyunxiao
 * @date 2021/3/9
 * @description
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1 finished!");
            return "future1 finished!";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future2 finished!");
            return "future2 finished!";
        });
        CompletableFuture<Void> combindFuture = CompletableFuture.allOf(future1, future2);
        try {
            combindFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("future1: " + future1.isDone() + " future2: " + future2.isDone());

        // CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
        //
        // });

    }

}
