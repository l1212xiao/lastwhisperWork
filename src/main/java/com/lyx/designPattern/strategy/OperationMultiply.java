package com.lyx.designPattern.strategy;

/**
 * @author lvyunxiao
 * @classname OperationMultiply
 * @description OperationMultiply
 * @date 2020/4/27
 */
public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
