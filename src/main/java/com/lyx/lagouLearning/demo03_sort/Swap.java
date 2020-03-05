package com.lyx.lagouLearning.demo03_sort;

/**
 * @author lvyunxiao
 * @classname Swap
 * @description Swap
 * @date 2019/12/25
 */
public class Swap {

    // use for sort
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
