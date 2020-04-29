package com.lyx.designPattern.abstractFactory;

/**
 * @author lvyunxiao
 * @classname Blue
 * @description Blue
 * @date 2020/4/27
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
