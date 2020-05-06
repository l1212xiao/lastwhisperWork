package com.lyx.designPattern.decorator;

/**
 * @author lvyunxiao
 * @classname Circle
 * @description Circle
 * @date 2020/4/26
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
