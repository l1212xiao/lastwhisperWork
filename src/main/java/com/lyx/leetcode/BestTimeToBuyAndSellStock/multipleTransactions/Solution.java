package com.lyx.BestTimeToBuyAndSellStock.multipleTransactions;

/**
 * Created by lyx on 2018/5/3.
 */
public class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) return 0;

        int minPrice = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                profit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return profit;

    }
}
