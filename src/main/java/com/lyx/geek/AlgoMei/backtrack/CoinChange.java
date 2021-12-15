package com.lyx.geek.AlgoMei.backtrack;

/*
322. 零钱兑换
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。

示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0
示例 4：

输入：coins = [1], amount = 1
输出：1
示例 5：

输入：coins = [1], amount = 2
输出：2
 */


import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2021/8/10
 * @description
 */
public class CoinChange {


    /*
    https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
     */
    // 方法一：记忆化搜索
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        // rem[i] 表示组成金额i所需的最少硬币数
        int[] mem = new int[amount + 1];
        return coinChange(coins, amount, mem);
    }

    private int coinChange(int[] coins, int rem, int[] men) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (men[rem] != 0) {
            return men[rem];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, men);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        men[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return men[rem];
    }

    // 方法二：动态规划
    public int coinChangeDp(int[] coins, int amount) {
        // 最大数量不超过总面值+1
        int maxVal = amount + 1;
        // dp[i] 表示凑成面值i所需的最小硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, maxVal);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
