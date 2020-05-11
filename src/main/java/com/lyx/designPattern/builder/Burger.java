package com.lyx.designPattern.builder;

/**
 * @author lvyunxiao
 * @classname Burger
 * @description Burger
 * @date 2020/5/9
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
