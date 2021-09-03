package com.lyx.geek.AlgoMei.dynamicProgramming;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2021/8/10
 * @description
 */
public class CoinChange {

    /*
    F(i)为组成金额 i 所需最少的硬币数量
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
