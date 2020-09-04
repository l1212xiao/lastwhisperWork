package com.lyx.leetcode.DynamicProgramming;

/**
 * @author lvyunxiao
 * <p>
 * 动态规划----背包问题
 * reference:
 * https://blog.csdn.net/likunkun__/article/details/80223003
 * https://blog.csdn.net/mingyuli/article/details/79686703
 * <p>
 * 一、问题描述：（01背包即每个物品最多放一个）
 * 01 背包问题：给定 n 种物品和一个容量为 c 的背包，物品 i 的重量是 w[i]，其价值为 v[i] 。
 * 问：应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大？
 * 二、理论解释：
 * 声明一个 大小为  m[n][c] 的二维数组，
 * m[i][j]表示在面对第i件物品，且背包容量为j时所能获得的最大价值，那么我们可以很容易分析得出m[i][j]的计算方法，
 * （1)j<w[i]的情况，这时候背包容量不足以放下第i件物品，只能选择不拿
 * m[i][j]=m[i-1][j]
 * （2)j>=w[i]的情况，这时背包容量可以放下第i件物品，我们就要考虑拿这件物品是否能获取更大的价值。
 * 如果拿取，m[i][j]=m[i-1][j-w[i]]+v[i]。这里的 m[i-1][j-w[i]] 指的就是考虑了i-1件物品，背包容量为 j-w[i] 时的最大价值，也是相当于为第i件物品腾出了w[i]的空间。
 * 如果不拿，m[i][j]=m[i-1][j],同（1）
 * 究竟是拿还是不拿，自然是比较这两种情况那种价值最大。
 *
 * <p>
 * @Classname Knapsack
 * @Description Knapsack
 * @Date 2019/8/16
 */
public class Knapsack {

    public static int knapsack(int[] w, int[] v, int c) {

        int n = w.length - 1;
        int[][] dp = new int[n + 1][c + 1];
        dp[0][n] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        return dp[n][c];
    }


    public static void main(String[] args) {
        int[] weight = {2, 3, 4, 5};
        int[] value = {3, 4, 5, 7};
        int maxweight = 9;
        System.out.println(knapsack(weight, value, maxweight));
    }

}
