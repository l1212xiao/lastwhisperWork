package com.lyx.designPattern.interpreter;

/**
 * @author lvyunxiao
 * @classname Expression
 * @description Expression
 * @date 2020/5/11
 */
public interface Expression {
    public boolean interpret(String context);
}
