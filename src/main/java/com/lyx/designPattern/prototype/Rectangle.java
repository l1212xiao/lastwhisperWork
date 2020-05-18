package com.lyx.designPattern.prototype;

/**
 * @author lvyunxiao
 * @classname Rectangle
 * @description Rectangle
 * @date 2020/5/11
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
