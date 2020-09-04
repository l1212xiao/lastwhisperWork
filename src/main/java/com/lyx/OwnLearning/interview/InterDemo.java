package com.lyx.OwnLearning.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/7/27
 */
public class InterDemo {
    public static void main(String[] args) {
        byte a = 1;
        byte b = 127;
        // b = b + a; 报编译错误:cannot convert from int to byte
        b += a;
        System.out.println(b); //128

        //short s1 = 1;
        // s1 = s1 + 1;
        // 有错误.short类型在进行运算时会自动提升为int类型,也就是说 s1+1 的运算结果是int类型,而s1是short类型,此时编译器会报错.
        short s1 = 1;
        s1 += 1;

        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};

        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
