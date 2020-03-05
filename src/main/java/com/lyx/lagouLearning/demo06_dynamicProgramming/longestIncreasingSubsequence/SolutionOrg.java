package com.lyx.lagouLearning.demo06_dynamicProgramming.longestIncreasingSubsequence;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @classname SolutionOrg
 * @description SolutionOrg
 * @date 2020/3/3
 */
public class SolutionOrg {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        SolutionOrg solutionOrg = new SolutionOrg();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int length = solutionOrg.lengthOfLIS(nums);
        System.out.println("length is " + length);
    }

}
