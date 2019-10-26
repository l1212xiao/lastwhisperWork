package com.lyx.OwnLearning.syncDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Classname SyncDemo
 * @Description SyncDemo
 * @Date 2019/10/10
 * @auther lvyunxiao
 */
public class SyncDemo {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("xxx");
        System.out.println();
    }
}
