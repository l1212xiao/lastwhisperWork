package com.lyx.leetcode.BestTimeToBuyAndSellStock.common;

/**
 * Created by lyx on 2018/5/3.
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0;
        int minPrices = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrices) {
                minPrices = prices[i];
            }
            if (prices[i] - minPrices > maxProfit) {
                maxProfit = prices[i] - minPrices;
            }
        }

        return maxProfit;
    }
}
