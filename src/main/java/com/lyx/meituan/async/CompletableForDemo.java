package com.lyx.meituan.async;

import com.google.common.collect.Lists;
import com.lyx.utils.FastJsonUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lvyunxiao
 * @date 2021/3/29
 * @description
 */
public class CompletableForDemo {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        List<CompletableFuture<Integer>> futures = Lists.newArrayList();
        List<Integer> paramList = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            paramList.add(i);
        }

        for (Integer param : paramList) {
            CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> doSomething(param), threadPool);
            futures.add(future);
        }
        futures.forEach(CompletableFuture::join);
        // CompletableFuture.allOf(futures.toArray(new CompletableFuture[paramList.size()])).join();
        threadPool.shutdown();

        List<Integer> result = Lists.newArrayList();
        for (CompletableFuture<Integer> future : futures) {
            try {
                Integer hi = future.get();
                result.add(hi);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(FastJsonUtils.toJSONStr(result));

        // MT
        List<CompletableFuture<Void>> mtFutures = Lists.newArrayList();
        List<Integer> ofwOrderSummaryPos = new ArrayList<>();
        List<Integer> allRdcIds = Lists.newArrayList(1, 2, 3);
        for (Integer rdcId : allRdcIds) {
            List<Long> thisRdcSummaries = Lists.newArrayList();
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> doSomething());
            mtFutures.add(future);
        }
        mtFutures.forEach(CompletableFuture::join);

        System.out.println("finish MT !");

    }

    public static int doSomething(int i) {
        Thread thread = Thread.currentThread();

        final Random random = new Random();
        final int nextInt = random.nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(nextInt);
            System.out.println(thread.getName() + " nextInt: " + nextInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i * 10;
    }

    public static void doSomething() {
        Thread thread = Thread.currentThread();

        final Random random = new Random();
        final int nextInt = random.nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(nextInt);
            System.out.println(thread.getName() + " nextInt: " + nextInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
