package com.lyx.geek.AlgoMei.dynamicProgramming;

/*
53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

示例 2：

输入：nums = [1]
输出：1

示例 3：

输入：nums = [0]
输出：0

示例 4：

输入：nums = [-1]
输出：-1

示例 5：

输入：nums = [-100000]
输出：-100000

 */


/**
 * @author lvyunxiao
 * @date 2021/8/13
 * @description
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        // dp[i]表示已第i个数字结尾的连续字数组最大和
        int[] dp = new int[length];
        dp[0] = nums[0];
        int maxSubArr = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSubArr = Math.max(dp[i], maxSubArr);
        }
        return maxSubArr;
    }

    public static void main(String[] args) {
        MaximumSubarray s = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = s.maxSubArray(nums);
        System.out.println(maxSubArray);
    }



}
