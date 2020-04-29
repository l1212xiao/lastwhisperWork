package com.lyx.designPattern.strategy;

/**
 * @author lvyunxiao
 * @classname OperationSubtract
 * @description OperationSubtract
 * @date 2020/4/27
 */
public class OperationSubtract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
