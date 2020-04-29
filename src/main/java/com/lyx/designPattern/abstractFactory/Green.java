package com.lyx.designPattern.abstractFactory;

/**
 * @author lvyunxiao
 * @classname Green
 * @description Green
 * @date 2020/4/27
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
