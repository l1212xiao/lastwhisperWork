package com.lyx.designPattern.bridge;

/**
 * @author lvyunxiao
 * @classname Shape
 * @description Shape
 * @date 2020/5/9
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
