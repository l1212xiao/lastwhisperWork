package com.lyx.lagouLearning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lvyunxiao
 * @classname StringDemo
 * @description StringDemo
 * @date 2019/11/27
 */
public class StringDemo {

    public static void main(String[] args) {

        String algo = "algorithm";
        char[] chars = algo.toCharArray();

        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }

        final String s = String.valueOf(chars);
        System.out.println(s);

        final List<Object> objects = new ArrayList<>();
        final List<Object> objects1 = new LinkedList<>();

    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
