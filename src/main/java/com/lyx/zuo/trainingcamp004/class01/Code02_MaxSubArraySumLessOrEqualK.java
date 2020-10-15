package com.lyx.zuo.trainingcamp004.class01;

/*
给定一个数组arr，再给定一个k值
返回累加和小于等于k，但是离k最近的子数组累加和
 */


import java.util.TreeSet;

public class Code02_MaxSubArraySumLessOrEqualK {

    // 请返回arr中，求个子数组的累加和，是<=K的，并且是最大的。
    // 返回这个最大的累加和
    public static int getMaxLessOrEqualK(int[] arr, int K) {
        // 记录i之前的，前缀和，按照有序表组织
        TreeSet<Integer> set = new TreeSet<>();
        // 一个数也没有的时候，就已经有一个前缀和是0了
        set.add(0);

        int max = Integer.MIN_VALUE;
        int sum = 0;
        // 每一步的i，都求子数组必须以i结尾的情况下，求个子数组的累加和，是<=K的，并且是最大的
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // sum -> arr[0..i];
            // Integer ceiling = set.ceiling(sum - K);
            // System.out.println(ceiling);
            // floor：返回此 set 中小于等于给定元素的最大元素；如果不存在这样的元素，则返回 null。
            // ceiling：返回此 set 中大于等于给定元素的最小元素；如果不存在这样的元素，则返回 null。
            if (set.ceiling(sum - K) != null) {
                max = Math.max(max, sum - set.ceiling(sum - K));
            }
            set.add(sum); // 当前的前缀和加入到set中去
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 7;
        int maxLessOrEqualK = getMaxLessOrEqualK(nums, k);
        System.out.println(maxLessOrEqualK);
    }

}
