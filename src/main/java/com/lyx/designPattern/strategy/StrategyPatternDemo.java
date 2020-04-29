package com.lyx.designPattern.strategy;

/**
 * @author lvyunxiao
 * @classname StrategyPatternDemo
 * @description StrategyPatternDemo
 * @date 2020/4/27
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

        // Exception in thread "main" java.lang.IllegalArgumentException: divisor can not be zero!
        // context = new Context(new OperationDivide());
        // System.out.println("10 / 0 = " + context.executeStrategy(10, 0));

        context = new Context(new OperationDivide());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
