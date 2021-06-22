package com.lyx.meituan.ArraysDemo;

import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2021/3/27
 * @description
 * https://mp.weixin.qq.com/s/c8RUOHax7BzJFg22jw2KGg
 */
public class ArraysAsListDemo {

    public static void main(String[] args) {
        final List<Integer> statusList = Arrays.asList(1, 2);
        System.out.println(statusList);
        System.out.println(statusList.contains(1));
        System.out.println(statusList.contains(3));

        statusList.add(3); // java.lang.UnsupportedOperationException
        System.out.println(statusList.contains(1));
        System.out.println(statusList.contains(3));

    }

}
