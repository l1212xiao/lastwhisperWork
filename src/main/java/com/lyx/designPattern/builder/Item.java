package com.lyx.designPattern.builder;

/**
 * @author lvyunxiao
 * @classname Item
 * @description Item
 * @date 2020/5/9
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}