package com.lyx.everyDayTraining.WhenInMT.smallestKlcci;

/*
面试题 17.14. 最小K个数
设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

示例：
输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author lvyunxiao
 * @date 2021/9/3
 * @description
 */
public class Solution {

    // 堆
    public int[] smallestK(int[] arr, int k) {
        if (arr.length <= k) {
            return arr;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int x : arr) {
            queue.add(x);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    // 快排

    public int[] smallestK2(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        int[] res = s.smallestK(arr, k);
        String string = Arrays.toString(res);
        System.out.println(string);
    }

}
