package com.lyx.designPattern.facade;

/**
 * @author lvyunxiao
 * @classname Rectangle
 * @description Rectangle
 * @date 2020/4/26
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println(" Rectangle::draw() method.");
    }
}
