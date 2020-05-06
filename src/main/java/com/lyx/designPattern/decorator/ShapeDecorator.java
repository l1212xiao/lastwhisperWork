package com.lyx.designPattern.decorator;

/**
 * @author lvyunxiao
 * @classname ShapeDecorator
 * @description ShapeDecorator
 * @date 2020/4/29
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(){
        decoratedShape.draw();
    }
}
