package com.lyx.geek.AlgoMei.sort;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2021/7/14
 * @description ref: https://time.geekbang.org/column/article/42038
 * 三种时间复杂度是 O(n) 的排序算法：桶排序、计数排序、基数排序。
 * 因为这些排序算法的时间复杂度是线性的，所以我们把这类排序算法叫作线性排序（Linear sort）。
 * 之所以能做到线性的时间复杂度，主要原因是，这三个算法是非基于比较的排序算法，都不涉及元素之间的比较操作。
 */
public class LinearSortDemo {

    public static void main(String[] args) {
        LinearSortDemo s = new LinearSortDemo();
        int[] arr = new int[]{2, 5, 3, 0, 2, 3, 0, 3};

        System.out.println("before: " + Arrays.toString(arr));
        s.countingSort(arr);
        System.out.println("after:  " + Arrays.toString(arr));

    }


    // 计数排序，a是数组，n是数组大小，假设数组中存储的都是非负整数
    public void countingSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }

        //查找数组中的数据范围
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; i++) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }

    }


}
