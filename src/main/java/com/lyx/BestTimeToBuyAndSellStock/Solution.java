package com.lyx.BestTimeToBuyAndSellStock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyx on 2018/5/3.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        List<Integer> list = new ArrayList<Integer>();
        int lowPrice = prices[0];
        int highPrice = prices[0];
        int maxPro = highPrice - lowPrice;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowPrice) {
                if (highPrice - lowPrice > maxPro) maxPro = highPrice-lowPrice;
                lowPrice = prices[i];
                highPrice = lowPrice;
            }
            for (int j = i; j < prices.length; j++) {
                if (prices[j] > highPrice) {
                    highPrice = prices[j];
                    if (highPrice - lowPrice > maxPro) maxPro = highPrice-lowPrice;
                }
            }
        }
        if (maxPro <= 0) return 0;
        return maxPro;
    }
}
