package com.lyx.designPattern.builder;

/**
 * @author lvyunxiao
 * @classname Coke
 * @description Coke
 * @date 2020/5/9
 */
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}