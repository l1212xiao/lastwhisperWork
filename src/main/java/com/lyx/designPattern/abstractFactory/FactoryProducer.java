package com.lyx.designPattern.abstractFactory;

/**
 * @author lvyunxiao
 * @classname FactoryProducer
 * @description FactoryProducer
 * @date 2020/4/27
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
