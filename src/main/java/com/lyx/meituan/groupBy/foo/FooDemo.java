package com.lyx.meituan.groupBy.foo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lvyunxiao
 * @date 2021/3/8
 * @description
 */
public class FooDemo {
    public static void main(String[] args) {

        Foo foo1 = new Foo(1, 2);
        Foo foo2 = new Foo(2, 23);
        Foo foo3 = new Foo(2, 6);

        List<Foo> list = new ArrayList<>(4);
        list.add(foo1);
        list.add(foo2);
        list.add(foo3);

        Map<Integer, List<Foo>> collect = list.stream().collect(Collectors.groupingBy(Foo::getCode));

        List<Foo> list1 = collect.get(1);
        List<Foo> list2 = collect.get(2);
        list1.forEach(e -> System.out.println(e.getCode() + ":" + e.getCount()));
        System.out.println("-----------这里是分界线-----------------------------");
        list2.forEach(e -> System.out.println(e.getCode() + ":" + e.getCount()));
    }
}
