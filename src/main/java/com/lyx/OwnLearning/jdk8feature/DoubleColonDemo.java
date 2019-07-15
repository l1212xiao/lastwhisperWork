package com.lyx.OwnLearning.jdk8feature;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Classname DoubleColonDemo
 * @Description defo for double colon（jdk8中双冒号的使用）
 * @Date 2019/7/13 15:01
 * @Created by lvyunxiao
 */
public class DoubleColonDemo {

    public static void printValue(String string) {
        System.out.println("print value : " + string);
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");

        //遍历list，执行打印value方法
        for (final String string : strings) {
            DoubleColonDemo.printValue(string);
        }

        //forEach写法
        strings.forEach(x -> DoubleColonDemo.printValue(x));

        //双冒号写法
        //JDK8中有双冒号的用法，就是把方法当做参数传到stream内部，
        //使stream的每个元素都传入到该方法里面执行一下。
        Consumer<String> printValue = DoubleColonDemo::printValue;
        //方法执行accept
        strings.forEach(x -> printValue.accept(x));
    }

}
