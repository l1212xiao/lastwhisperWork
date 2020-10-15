package com.lyx.zuo.trainingcamp004.class02;

/*
给定一个数组arr，从左到右表示昨天从早到晚股票的价格
作为一个事后诸葛亮，你想知道如果随便交易，
且每次交易只买卖一股，返回能挣到的最大钱数
 */


public class Code02_BestTimetoBuyandSellStock2 {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }

}
