package com.lyx.designPattern.builder;

/**
 * @author lvyunxiao
 * @classname Bottle
 * @description Bottle
 * @date 2020/5/9
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}