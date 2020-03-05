package com.lyx.javaL.proxyDemo;

/**
 * @author lvyunxiao
 * @classname ProxyUtil
 * @description ProxyUtil
 * @date 2020/3/5
 */
public class ProxyUtil {
    private static final String TAG = "ProxyUtil";

    public static void start() {
        System.out.println(TAG + " start: " + System.currentTimeMillis());
    }

    public static void finish() {
        System.out.println(TAG + " finish: " + System.currentTimeMillis());
    }

    public static void log(String name) {
        System.out.println(TAG + " log: " + name);
    }
}
