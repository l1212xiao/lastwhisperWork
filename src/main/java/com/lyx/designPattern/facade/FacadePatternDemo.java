package com.lyx.designPattern.facade;

/**
 * @author lvyunxiao
 * @classname FacadePatternDemo
 * @description FacadePatternDemo
 * @date 2020/4/29
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
