package com.lyx.designPattern.builder;

/**
 * @author lvyunxiao
 * @classname VegBurger
 * @description VegBurger
 * @date 2020/5/9
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
