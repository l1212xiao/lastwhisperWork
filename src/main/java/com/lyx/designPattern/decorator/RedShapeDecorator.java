package com.lyx.designPattern.decorator;

/**
 * @author lvyunxiao
 * @classname RedShapeDecorator
 * @description RedShapeDecorator
 * @date 2020/4/29
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
