package com.lyx.designPattern.abstractFactory;

/**
 * @author lvyunxiao
 * @classname Red
 * @description Red
 * @date 2020/4/27
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
