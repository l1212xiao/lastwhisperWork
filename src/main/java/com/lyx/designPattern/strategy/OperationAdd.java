package com.lyx.designPattern.strategy;

/**
 * @author lvyunxiao
 * @classname OperationAdd
 * @description OperationAdd
 * @date 2020/4/27
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
