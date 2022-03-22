package com.lyx.everyDayTraining.WhenInMT.bestTimeToBuyAndSellStock;

/*
121. 买卖股票的最佳时机
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

示例 1：

输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

示例 2：

输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。

提示：
    1 <= prices.length <= 10^5
    0 <= prices[i] <= 10^4
 */


/**
 * @author lvyunxiao
 * @date 2022/3/1
 * @description
 */
public class Solution {

    /*
    暴力求解
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    /*
    minP[i] 表示[0,i]中最小的
    maxP[i] 表示[i,n-1]中最大的
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int max = 0;
        if (n == 0) {
            return max;
        }
        int[] minP = new int[n];
        int[] maxP = new int[n];
        minP[0] = prices[0];
        for (int i = 1; i < n; i++) {
            minP[i] = Math.min(minP[i - 1], prices[i]);
        }

        maxP[n - 1] = prices[n - 1];
        for (int i = n - 2; i > 0; i--) {
            maxP[i] = Math.max(maxP[i + 1], prices[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, maxP[i + 1] - minP[i]);
        }
        return max;
    }


    /*
    用一个变量记录历史最低价格，遍历数组，假设在当天售卖，按照历史最低点买入算最大收益，取最大收益
     */
    public int maxProfit3(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        // int maxProfit = s.maxProfit(prices);
        int maxProfit = s.maxProfit2(prices);
        System.out.println(maxProfit);
    }
}
