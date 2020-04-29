package com.lyx.designPattern.strategy;

/**
 * @author lvyunxiao
 * @classname Context
 * @description Context
 * @date 2020/4/27
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
