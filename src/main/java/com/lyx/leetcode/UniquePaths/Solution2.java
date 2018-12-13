package com.lyx.Path.UniquePaths;

/**
 * Created by lyx on 2018/7/5.
 * 62. Unique Paths
 */
//本题解法为动态规划
//状态方程为 f[i][j] = f[i-1][j] + f[i][j-1]
//f[i][j]的值即为路径的数量
public class Solution2 {
    public int uniquePaths(int m, int n) {

        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1; //第一列赋值为1
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1; //第一行赋值为1
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
