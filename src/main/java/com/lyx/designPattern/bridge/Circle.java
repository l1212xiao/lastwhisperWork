package com.lyx.designPattern.bridge;

/**
 * @author lvyunxiao
 * @classname Circle
 * @description Circle
 * @date 2020/5/9
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
