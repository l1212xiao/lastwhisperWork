package com.lyx.OwnLearning.lambdaDemo;

import java.util.function.IntBinaryOperator;

/**
 * @Classname LambdaDemo
 * @Description lambda 练习
 * @Date 2019/7/5 18:37
 * @Created by lvyunxiao
 */
public class LambdaDemo {

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {

        LambdaDemo lambdaDemo = new LambdaDemo();

        MathOperation addition = (int a, int b) -> a + b;

        System.out.println("10 + 5 = " + lambdaDemo.operate(10, 5, addition));

    }
}
