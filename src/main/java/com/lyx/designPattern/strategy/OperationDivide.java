package com.lyx.designPattern.strategy;

/**
 * @author lvyunxiao
 * @classname OperationDivide
 * @description OperationDivide
 * @date 2020/4/27
 */
public class OperationDivide implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("divisor can not be zero!");
        }
        return num1 / num2;
    }
}
