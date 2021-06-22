package com.lyx.JUC;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author lvyunxiao
 * @date 2021/4/26
 * @description
 */
public class ConcurrentLinkedQueueDemo {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        // 三大操作，均是并发安全的，也即多线程操作安全
        boolean add1 = concurrentLinkedQueue.add(1);

    }

}
