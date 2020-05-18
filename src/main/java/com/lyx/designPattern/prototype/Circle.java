package com.lyx.designPattern.prototype;

/**
 * @author lvyunxiao
 * @classname Circle
 * @description Circle
 * @date 2020/5/11
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
