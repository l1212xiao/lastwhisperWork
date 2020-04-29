package com.lyx.designPattern.facade;

/**
 * @author lvyunxiao
 * @classname Circle
 * @description Circle
 * @date 2020/4/26
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println(" Circle::draw() method.");
    }
}
