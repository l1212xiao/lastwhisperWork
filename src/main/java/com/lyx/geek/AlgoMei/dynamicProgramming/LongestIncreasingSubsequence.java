package com.lyx.geek.AlgoMei.dynamicProgramming;

/*
300. 最长递增子序列
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：

输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：

输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：

输入：nums = [7,7,7,7,7,7,7]
输出：1
 */


import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2021/8/11
 * @description
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // dp[i]表示考虑前i个元素，以第i个结尾的最长上升子序列的长度，nums[i]必须选取
        int[] dp = new int[len];
        int maxRes = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxRes = Math.max(maxRes, dp[i]);
        }
        return maxRes;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int lengthOfLIS = s.lengthOfLIS(nums);
        System.out.println(lengthOfLIS);

    }
}
