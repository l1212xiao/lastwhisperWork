package com.lyx.designPattern.decorator;

/**
 * @author lvyunxiao
 * @classname Square
 * @description Square
 * @date 2020/4/26
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
