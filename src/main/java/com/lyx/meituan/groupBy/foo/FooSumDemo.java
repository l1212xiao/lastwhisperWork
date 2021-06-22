package com.lyx.meituan.groupBy.foo;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lvyunxiao
 * @date 2021/3/8
 * @description
 */
public class FooSumDemo {
    public static void main(String[] args) {
        Foo foo1 = new Foo(1, 2);
        Foo foo2 = new Foo(2, 23);
        Foo foo3 = new Foo(2, 6);
        List<Foo> list = new ArrayList<>(4);
        list.add(foo1);
        list.add(foo2);
        list.add(foo3);
        Map<Integer, IntSummaryStatistics> collect = list.stream()
            .collect(Collectors.groupingBy(Foo::getCode, Collectors.summarizingInt(Foo::getCount)));
        IntSummaryStatistics statistics1 = collect.get(1);
        IntSummaryStatistics statistics2 = collect.get(2);

        System.out.println(statistics1.getSum());
        System.out.println(statistics1.getAverage());
        System.out.println(statistics1.getMax());
        System.out.println(statistics1.getMin());
        System.out.println(statistics1.getCount());

        System.out.println(statistics2.getSum());
        System.out.println(statistics2.getAverage());
        System.out.println(statistics2.getMax());
        System.out.println(statistics2.getMin());
        System.out.println(statistics2.getCount());
    }
}
