package com.lyx.everyDayTraining.WhenInMT.bestTimeToBuyAndSellStock.IV;

/*
188. 买卖股票的最佳时机 IV
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1：

输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。

示例 2：

输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

提示：
    0 <= k <= 100
    0 <= prices.length <= 1000
    0 <= prices[i] <= 1000
 */

/**
 * @author lvyunxiao
 * @date 2022/3/2
 * @description
 */
public class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        k = Math.min(k, n / 2);
        // buy[n]  第n次买入的最大收益
        // sell[n] 第n次卖出的最大收益
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            buy[i] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }
        return sell[k];
    }

    public int maxProfitOwn(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        k = Math.min(k, n / 2);
        // dp[i][k][0] 第i天，第k笔交易，不持有股票的最大收益
        // dp[i][k][1] 第i天，第k笔交易，持有股票的最大收益
        int[][][] dp = new int[n][k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i][0][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int[] prices = {3, 2, 6, 5, 0, 3};
        // int k = 2;
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int k = 2;
        // int maxProfit = s.maxProfit(k, prices);
        int maxProfit = s.maxProfitOwn(k, prices);
        System.out.println(maxProfit);
    }

}
