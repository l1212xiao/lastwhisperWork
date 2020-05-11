package com.lyx.designPattern.bridge;

/**
 * @author lvyunxiao
 * @classname RedCircle
 * @description RedCircle
 * @date 2020/5/9
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}
