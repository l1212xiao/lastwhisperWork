package com.lyx.lagouLearning.demo01.Deque.slidingWindowMaximum;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/6
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length * k == 0) {
            return new int[0];
        }
        int[] maxResult = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int end = i + k;
            maxResult[i] = getMax(nums, i, end);
        }
        return maxResult;
    }

    public static int getMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution solution = new Solution();
        final int[] ints = solution.maxSlidingWindow(nums, 3);

        for (final int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

}
