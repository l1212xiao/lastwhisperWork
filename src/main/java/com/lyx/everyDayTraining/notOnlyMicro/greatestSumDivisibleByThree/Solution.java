package com.lyx.everyDayTraining.notOnlyMicro.greatestSumDivisibleByThree;

/*
1262. 可被三整除的最大和
给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。

示例 1：

输入：nums = [3,6,5,1,8]
输出：18
解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。

示例 2：

输入：nums = [4]
输出：0
解释：4 不能被 3 整除，所以无法选出数字，返回 0。

示例 3：

输入：nums = [1,2,3,4,4]
输出：12
解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。

提示：
    1 <= nums.length <= 4 * 10^4
    1 <= nums[i] <= 10^4

 */


/**
 * @author lvyunxiao
 * @date 2022/4/2
 * @description
 */
public class Solution {

    /*
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            if (nums[0] % 3 == 0) {
                return nums[0];
            } else {
                return 0;
            }
        }
        // dp[i][j] 表示nums[0,i]中，模为j的最大和
        int[][] dp = new int[n][3];
        dp[0][0] = nums[0] % 3 == 0 ? nums[0] : 0;
        dp[0][1] = nums[0] % 3 == 1 ? nums[0] : 0;
        dp[0][2] = nums[0] % 3 == 2 ? nums[0] : 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] % 3 == 0) {
                dp[i][0] = dp[i - 1][0] == 0 ? nums[i] : dp[i - 1][0] + nums[i];
                dp[i][1] = dp[i - 1][1] == 0 ? dp[i - 1][1] : Math.max(dp[i - 1][1], dp[i - 1][1] + nums[i]);
                dp[i][2] = dp[i - 1][2] == 0 ? dp[i - 1][2] : Math.max(dp[i - 1][2], dp[i - 1][2] + nums[i]);
            } else if (nums[i] % 3 == 1) {
                dp[i][0] = dp[i - 1][2] == 0 ? dp[i - 1][0] : Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i]);
                dp[i][1] = dp[i - 1][0] == 0 ? Math.max(dp[i - 1][1], nums[i])
                    : Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
                dp[i][2] = dp[i - 1][1] == 0 ? dp[i - 1][2] : Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i]);
            } else {
                dp[i][0] = dp[i - 1][1] == 0 ? dp[i - 1][0] : Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
                dp[i][1] = dp[i - 1][2] == 0 ? dp[i - 1][1] : Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i]);
                dp[i][2] = dp[i - 1][0] == 0 ? Math.max(dp[i - 1][2], nums[i])
                    : Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i]);
            }
        }
        return dp[n - 1][0];
    }
     */

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            if (nums[0] % 3 == 0) {
                return nums[0];
            } else {
                return 0;
            }
        }
        // dp[i][j] 表示nums[0,i]中，模为j的最大和
        int[][] dp = new int[n][3];
        dp[0][0] = nums[0] % 3 == 0 ? nums[0] : 0;
        dp[0][1] = nums[0] % 3 == 1 ? nums[0] : 0;
        dp[0][2] = nums[0] % 3 == 2 ? nums[0] : 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] % 3 == 0) {
                dp[i][0] = dp[i - 1][0] + nums[i];
                dp[i][1] = dp[i - 1][1] == 0 ? dp[i - 1][1] : dp[i - 1][1] + nums[i];
                dp[i][2] = dp[i - 1][2] == 0 ? dp[i - 1][2] : dp[i - 1][2] + nums[i];
            } else if (nums[i] % 3 == 1) {
                dp[i][0] = dp[i - 1][2] == 0 ? dp[i - 1][0] : Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
                dp[i][2] = dp[i - 1][1] == 0 ? dp[i - 1][2] : Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i]);
            } else {
                dp[i][0] = dp[i - 1][1] == 0 ? dp[i - 1][0] : Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
                dp[i][1] = dp[i - 1][2] == 0 ? dp[i - 1][1] : Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i]);
            }
        }
        return dp[n - 1][0];
    }

    /*
    链接：https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/solution/java-1262-ke-bei-san-zheng-chu-de-zui-da-bre8/
解题思路
截至位置k，mod0为模==0的最大累加和，mod1模==1的最大累加和，mod2模==2的最大累加和
并以此求出k+1位置的mod0，mod1，mod2
滚动求和要同原mod值比较，取大。
     */
    public int maxSumDivThree2(int[] nums) {
        int mod0 = 0, mod1 = 0, mod2 = 0;
        int cur0 = 0, cur1 = 0, cur2 = 0;
        for (int num : nums) {
            int mod = num % 3;
            if (mod == 0) {
                cur0 = mod0 + num;
                cur1 = mod1 == 0 ? mod1 : mod1 + num;
                cur2 = mod2 == 0 ? mod2 : mod2 + num;
            } else if (mod == 1) {
                cur0 = mod2 == 0 ? mod0 : Math.max(mod0, mod2 + num);
                cur1 = Math.max(mod1, mod0 + num);
                cur2 = mod1 == 0 ? mod2 : Math.max(mod1, mod1 + num);
            } else if (mod == 2) {
                cur0 = mod1 == 0 ? mod0 : Math.max(mod0, mod1 + num);
                cur1 = mod2 == 0 ? mod1 : Math.max(mod1, mod2 + num);
                cur2 = Math.max(mod2, mod0 + num);
            }
            mod0 = cur0;
            mod1 = cur1;
            mod2 = cur2;
        }
        return mod0;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 6, 5, 1, 8};
        // int[] nums = {1, 2, 3, 4, 4};
        int maxSumDivThree = s.maxSumDivThree(nums);
        System.out.println(maxSumDivThree);
    }
}
