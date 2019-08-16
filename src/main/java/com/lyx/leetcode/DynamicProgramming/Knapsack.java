package com.lyx.leetcode.DynamicProgramming;

/**
 * @Classname Knapsack
 * @Description Knapsack
 * @Date 2019/8/16
 * @auther lvyunxiao
 * <p>
 * 动态规划----背包问题
 * reference:
 * https://blog.csdn.net/likunkun__/article/details/80223003
 * https://blog.csdn.net/mingyuli/article/details/79686703
 */
public class Knapsack {

    public static int knapsack(int[] w, int[] v, int c) {

        int n = w.length - 1;

        int[][] m = new int[n + 1][c + 1];
        m[0][n] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (j >= w[i]) {
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        return m[n][c];
    }


    public static void main(String[] args) {
        int[] weight = {2, 3, 4, 5};
        int[] value = {3, 4, 5, 7};
        int maxweight = 9;
        System.out.println(knapsack(weight, value, maxweight));
    }

}
