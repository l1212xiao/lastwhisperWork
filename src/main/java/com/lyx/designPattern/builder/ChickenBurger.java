package com.lyx.designPattern.builder;

/**
 * @author lvyunxiao
 * @classname ChickenBurger
 * @description ChickenBurger
 * @date 2020/5/9
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
