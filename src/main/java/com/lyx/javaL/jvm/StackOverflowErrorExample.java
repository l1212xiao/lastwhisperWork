package com.lyx.javaL.jvm;

/**
 * @author lvyunxiao
 * @classname StackOverflowErrorExample
 * @description StackOverflowErrorExample
 * @date 2020/3/20
 */
public class StackOverflowErrorExample {
    public static void main(String[] args) {
        a();
    }
    public static void a() {
        a();
    }
}
