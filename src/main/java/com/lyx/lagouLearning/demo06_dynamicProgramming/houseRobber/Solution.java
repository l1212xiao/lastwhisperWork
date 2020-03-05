package com.lyx.lagouLearning.demo06_dynamicProgramming.houseRobber;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/3
 */
public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;

        // 处理当前数组为空或者数组只有一个元素的情况
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        // 定义一个dp数组，dp[i]表示到第i个元素为止得到的最大数
        int[] dp = new int[length];

        // 初始化dp[0],dp[1]
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 对于每个nums[i],考虑两种情况，选还是不选，然后选最大值
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[length - 1];
    }
}
