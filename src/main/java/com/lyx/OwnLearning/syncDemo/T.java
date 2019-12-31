package com.lyx.OwnLearning.syncDemo;

import java.util.WeakHashMap;

/**
 * @author lvyunxiao
 * @classname T
 * @description T
 * @date 2019/12/19
 */
public class T {

    volatile int anInt;

    public static void main(String[] args) {
        WeakHashMap weakHashMap = new WeakHashMap();
        weakHashMap.put("hi", "world");
        System.out.println(weakHashMap.get("hi"));
    }
}
