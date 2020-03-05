package com.lyx.lagouLearning.demo06_dynamicProgramming.moveStep;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/3
 * <p>
 * 不同路径(一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？)
 * 62：https://leetcode-cn.com/problems/unique-paths/
 */
public class Solution {
    /**
     * 动态规划：我们可以定义二维数组arr，横坐标为m，纵坐标为n
     * 根据题意，我们令dp[0][0] = 1,dp[0][j] = 1,dp[i][0] = 1,其中0<i<m,0<j<n
     * dp[i][j] = dp[i-1][j] + dp[i][j - 1]
     * 最后直接返回二维数组最后一个数组
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (i - 1 == 0) {
                    dp[i - 1][j] = 1;
                }
                if (j - 1 == 0) {
                    dp[i][j - 1] = 1;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


}
