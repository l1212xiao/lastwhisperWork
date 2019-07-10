package com.lyx.leetcode.CoinChange;

/**
 * Created by lyx on 2018/7/5.
 */
public class Test {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Solution solution = new Solution();
        int x = solution.coinChange(coins, amount);
        System.out.println(x);
    }
}
