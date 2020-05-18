package com.lyx.designPattern.prototype;

/**
 * @author lvyunxiao
 * @classname Square
 * @description Square
 * @date 2020/5/11
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
