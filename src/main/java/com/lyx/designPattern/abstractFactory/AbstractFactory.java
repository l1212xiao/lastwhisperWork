package com.lyx.designPattern.abstractFactory;

/**
 * @author lvyunxiao
 * @classname AbstractFactory
 * @description AbstractFactory
 * @date 2020/4/27
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
