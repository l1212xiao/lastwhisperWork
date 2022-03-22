package com.lyx.OwnLearning.jdk8feature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lvyunxiao
 * @date 2021/12/29
 * @description
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream().forEach(num -> System.out.print(num));

        System.out.println("");
        System.out.println("++++++");

        List<String> strs = numbers.stream().map(num -> Integer.toString(++num)).collect(Collectors.toList());
        strs.forEach(System.out::print);

        System.out.println("");
        System.out.println("++++++");


        // parallelStream 并行流
        numbers.parallelStream().forEach(num -> System.out.print(num));

        System.out.println("");
        System.out.println("++++++");

    }

}
