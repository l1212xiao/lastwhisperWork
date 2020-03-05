package com.lyx.lagouLearning.demo06_dynamicProgramming.longestIncreasingSubsequence;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @classname Solution2
 * @description Solution2
 * @date 2020/3/3
 */
public class Solution2 {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int max = 0;

        // 初始化 dp 数组里的每个元素的值为 1，即以每个元素作为结尾的最长子序列的长度初始化为 1
        Arrays.fill(dp, 1);

        // 自底向上地求解每个子问题的最优解
        for (int i = 0; i < length; i++) {
            //遍历中遇到的每个元素nums[j]与nums[i]比较，若nums[j]<nums[i]，
            // 说明nums[i]有机会构成上升序列，若新的上升序列比之前计算过的还要长，更新一下，保存
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] +1;
                }
            }
            // 用当前计算好的长度与全局的最大值进行比较 
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
