package com.lyx.designPattern.builder;

/**
 * @author lvyunxiao
 * @classname ColdDrink
 * @description ColdDrink
 * @date 2020/5/9
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
