package com.lyx.BestTimeToBuyAndSellStock.common;

/**
 * Created by lyx on 2018/5/3.
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {2, 4, 1};
        int profix = solution.maxProfit(prices);
        System.out.println(profix);
    }
}
