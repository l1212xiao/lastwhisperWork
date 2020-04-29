package com.lyx.designPattern.factory;

/**
 * @author lvyunxiao
 * @classname Rectangle
 * @description Rectangle
 * @date 2020/4/26
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
