package com.lyx.everyDayTraining.WhenInMT.knapsack;

/*
0-1背包问题的描述。

问题：给你一个可放总重量为 c 的背包和 N 个物品，对每个物品，
有重量 w 和价值 v 两个属性，那么第 i 个物品的重量为 w[i]，价值为 v[i]。现在让你用这个背包装物品，问最多能装的价值是多少？

示例：

示例：

输入：c = 3
     w = [3, 2, 1], v = [5, 2, 3]
输出：8
解释：选择 i=0 和 i=2 这两件物品装进背包。它们的总重量 4 小于 W，同时可以获得最大价值 8。
 */

/**
 * @author lvyunxiao
 * @date 2021/12/29
 * @description
 */
public class KnapsackDemo {

    /**
     * 0-1背包问题
     *
     * @param w 物品重量数组
     * @param v 物品价值数组
     * @param c 背包重量
     * @return 能获取的最大价值
     */
    public static int knapsack01(int[] w, int[] v, int c) {

        // 表示物品的索引
        int n = w.length - 1;

        // dp[i][j]表示，放入第i件物品，背包可用容量为j时可获得的最大价值
        int[][] dp = new int[n + 1][c + 1];

        // 初始化
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < c + 1; j++) {
            dp[0][j] = 0;
        }
        // 遍历每一件物品
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                if (j >= w[i]) {
                    // 如果容量足够，那么可以选或者不选这件物品
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][c];
    }

    /**
     * 完全背包问题，每种物品都可以选择任意多个
     *
     * @param w 物品重量数组
     * @param v 物品价值数组
     * @param c 背包重量
     * @return 能获取的最大价值
     */
    public static int completedKnapsack(int[] w, int[] v, int c) {

        // 表示物品的索引
        int n = w.length - 1;

        // dp[i][j]表示，放入前i种物品，背包可用容量为j时可获得的最大价值
        int[][] dp = new int[n + 1][c + 1];

        // 初始化
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < c + 1; j++) {
            dp[0][j] = 0;
        }
        // 遍历每一件物品
        for (int i = 1; i < n + 1; i++) {
            // 背包容量有多大就还要计算多少次
            for (int j = 1; j < c + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k < j / w[i]; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * w[i] + k * v[i]]);
                }
            }
        }
        return dp[n][c];
    }

    /**
     * 完全背包问题，每种物品都可以选择任意多个
     *
     * @param w 物品重量数组
     * @param v 物品价值数组
     * @param c 背包重量
     * @return 能获取的最大价值
     */
    public static int completedKnapsack2(int[] w, int[] v, int c) {

        // 表示物品的索引
        int n = w.length - 1;

        // dp[i][j]表示，放入前i种物品，背包可用容量为j时可获得的最大价值
        int[][] dp = new int[n + 1][c + 1];

        // 初始化
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < c + 1; j++) {
            dp[0][j] = 0;
        }
        // 遍历每一件物品
        for (int i = 1; i < n + 1; i++) {
            // 背包容量有多大就还要计算多少次
            for (int j = 1; j < c + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                // 如果可以放入，则尝试放入第i件物品
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
                }
            }
        }
        return dp[n][c];
    }

    /**
     * 完全背包问题，每种物品都可以选择任意多个，改进代码的空间复杂度
     *
     * @param w 物品重量数组
     * @param v 物品价值数组
     * @param c 背包重量
     * @return 能获取的最大价值
     */
    public static int completedKnapsack3(int[] w, int[] v, int c) {

        // 表示物品的索引
        int n = w.length - 1;

        // dp[i][j]表示，放入前i种物品，背包可用容量为j时可获得的最大价值
        int[][] dp = new int[2][c + 1];

        // 初始化
        for (int i = 0; i < 2; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < c + 1; j++) {
            dp[0][j] = 0;
        }
        // 遍历每一件物品
        for (int i = 1; i < n + 1; i++) {
            // 背包容量有多大就还要计算多少次
            for (int j = 1; j < c + 1; j++) {
                // i % 2 代表当前行的缓存索引
                int in = i % 2;
                // 1 - cnt 代表上一行的缓存索引
                int im = 1 - in;
                dp[in][j] = dp[im][j];
                // 如果可以放入，则尝试放入第i件物品
                if (j >= w[i]) {
                    dp[in][j] = Math.max(dp[in][j], dp[in][j - w[i]] + v[i]);
                }
            }
        }
        return dp[n % 2][c];
    }


    public static void main(String[] args) {
        // int[] weight = {2, 3, 4, 5};
        // int[] value = {3, 4, 5, 7};
        // int maxWeight = 9;
        // System.out.println(knapsack(weight, value, maxWeight)); // 12

        // int[] weight = {3, 2, 1};
        // int[] value = {5, 2, 3};
        // int maxWeight = 8;
        // System.out.println(knapsack01(weight, value, maxWeight)); // 选择 i=0 和 i=2 这两件物品装进背包。它们的总重量 4 小于 W，同时可以获得最大价值 8。

        // int[] weight = {3, 2, 1};
        // int[] value = {5, 2, 3};
        // int maxWeight = 8;
        // System.out.println(completedKnapsack2(weight, value, maxWeight)); // 完全背包

        int[] weight = {3, 2, 1};
        int[] value = {5, 2, 3};
        int maxWeight = 8;
        System.out.println(completedKnapsack3(weight, value, maxWeight)); // 完全背包
    }

}
