package com.lyx.zuo.trainingcamp004.class02;

/*
给定一个数组arr，从左到右表示昨天从早到晚股票的价格。
作为一个事后诸葛亮，你想知道如果只做一次交易，且每次交易只买卖一股，
返回能挣到的最大钱数
 */



public class Code01_BestTimetoBuyandSellStock1 {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int min = prices[0];
		int ans = 0;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			ans = Math.max(ans, prices[i] - min);
		}
		return ans;
	}

}
