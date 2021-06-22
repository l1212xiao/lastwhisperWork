package com.lyx.meituan.guava;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import java.util.Set;
import org.junit.Test;

/**
 * @author lvyunxiao
 * @date 2021/3/10
 * @description
 */
public class SetsDemo {

    public static void main(String[] args) {

        Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4, 5);
        Set<Integer> set2 = Sets.newHashSet(3, 4, 5, 6, 7);

        //交集
        System.out.println("交集为：");
        SetView<Integer> intersection = Sets.intersection(set1, set2);
        for (Integer integer : intersection) {
            System.out.println(integer);
        }

        //差集
        System.out.println("差集为：");
        SetView<Integer> diff = Sets.difference(set1, set2);
        for (Integer integer : diff) {
            System.out.println(integer);
        }
        //并集
        System.out.println("并集为：");
        SetView<Integer> union = Sets.union(set1, set2);
        for (Integer integer : union) {
            System.out.println(integer);
        }
    }

    @Test
    public void testSets() {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 4, 5, 6, 8);
        Set<Integer> set2 = Sets.newHashSet(2, 3, 4, 5, 6, 7, 9);

        //合集，并集   [1, 2, 4, 5, 6, 8, 3, 7, 9]
        Set<Integer> result1 = Sets.union(set1, set2);
        //交集          [2, 4, 5, 6]
        Set<Integer> result2 = Sets.intersection(set1, set2);
        //差集 1中有而2中没有的  [1, 8]
        Set<Integer> result3 = Sets.difference(set1, set2);
        //相对差集 1中有2中没有  2中有1中没有的 取出来做结果 [1, 8, 3, 7, 9]
        Set<Integer> result4 = Sets.symmetricDifference(set1, set2);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

    }
}
