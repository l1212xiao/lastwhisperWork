package com.lyx.designPattern.mediator;

/**
 * @author lvyunxiao
 * @classname MediatorPatternDemo
 * @description MediatorPatternDemo
 * @date 2020/5/11
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
