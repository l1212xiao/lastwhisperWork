package com.lyx.designPattern.builder;

/**
 * @author lvyunxiao
 * @classname Pepsi
 * @description Pepsi
 * @date 2020/5/9
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
