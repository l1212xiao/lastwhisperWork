package com.lyx.everyDayTraining.notOnlyMicro.matrix.maximumNonNegativeProductInAMatrix;

/*
1594. 矩阵的最大非负积

给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，
找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。

返回 最大非负积 对 10^9 + 7 取余 的结果。如果最大积为负数，则返回 -1 。

注意，取余是在得到最大积之后执行的。

示例 1：

输入：grid = [[-1,-2,-3],
             [-2,-3,-3],
             [-3,-3,-2]]
输出：-1
解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1

示例 2：

输入：grid = [[1,-2,1],
             [1,-2,1],
             [3,-4,1]]
输出：8
解释：最大非负积对应的路径已经用粗体标出 (1 * 1 * -2 * -4 * 1 = 8)

示例 3：

输入：grid = [[1, 3],
             [0,-4]]
输出：0
解释：最大非负积对应的路径已经用粗体标出 (1 * 0 * -4 = 0)

示例 4：

输入：grid = [[ 1, 4,4,0],
             [-2, 0,0,1],
             [ 1,-1,1,1]]
输出：2
解释：最大非负积对应的路径已经用粗体标出 (1 * -2 * 1 * -1 * 1 * 1 = 2)

提示：
    1 <= rows, cols <= 15
    -4 <= grid[i][j] <= 4
 */


/**
 * @author lvyunxiao
 * @date 2022/3/14
 * @description
 */
public class Solution {

    public int maxProductPath(int[][] grid) {
        // maxDp[i][j] 表示走到当前路径的乘积中，最大的乘积
        // minDP[i][j] 表示走到当前路径的乘积中，最小的乘积
        int m = grid.length;
        int n = grid[0].length;
        long[][] maxPd = new long[m][n];
        long[][] minPd = new long[m][n];
        maxPd[0][0] = minPd[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            maxPd[i][0] = (maxPd[i - 1][0] * grid[i][0]);
            minPd[i][0] = (minPd[i - 1][0] * grid[i][0]);
        }
        for (int i = 1; i < n; i++) {
            maxPd[0][i] = (maxPd[0][i - 1] * grid[0][i]);
            minPd[0][i] = (minPd[0][i - 1] * grid[0][i]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxPd[i][j] = Math.max(maxPd[i - 1][j], maxPd[i][j - 1]) * grid[i][j];
                    minPd[i][j] = Math.min(minPd[i - 1][j], minPd[i][j - 1]) * grid[i][j];
                } else {
                    maxPd[i][j] = Math.min(minPd[i - 1][j], minPd[i][j - 1]) * grid[i][j];
                    minPd[i][j] = Math.max(maxPd[i - 1][j], maxPd[i][j - 1]) * grid[i][j];
                }
            }
        }
        final int MOD = 1000000007;
        if (maxPd[m - 1][n - 1] < 0) {
            return -1;
        } else {
            return (int) (maxPd[m - 1][n - 1] % MOD);
        }
    }

    public int maxProductPath2(int[][] grid) {
        final int MOD = 1000000000 + 7;
        int m = grid.length, n = grid[0].length;
        long[][] maxgt = new long[m][n];
        long[][] minlt = new long[m][n];

        maxgt[0][0] = minlt[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            maxgt[0][i] = minlt[0][i] = maxgt[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            maxgt[i][0] = minlt[i][0] = maxgt[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxgt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                    minlt[i][j] = Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
                } else {
                    maxgt[i][j] = Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
                    minlt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                }
            }
        }
        if (maxgt[m - 1][n - 1] < 0) {
            return -1;
        } else {
            return (int) (maxgt[m - 1][n - 1] % MOD);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int[][] grid = {
        //     {1, 4, 4, 0},
        //     {-2, 0, 0, 1},
        //     {1, -1, 1, 1}
        // };

        int[][] grid = {
            {1, -1, 2, 1, -1, 0, 0, 4, 3, 2, 0, -2, -2},
            {-2, 3, 3, -1, -1, 0, 0, -2, 4, -3, 3, 0, 0},
            {-4, -1, -1, -2, 2, -1, -2, -2, 0, 3, -1, -4, 1},
            {-3, 4, -3, 0, -3, 1, -3, 1, 4, 4, -4, -4, -2},
            {3, -3, 1, 0, -1, -4, -4, -4, 3, 2, 2, 3, 3},
            {2, -1, -1, -4, -3, -3, 4, 2, 3, 4, 4, -4, 0},
            {4, -1, 2, -3, -1, -1, -3, -4, 4, 4, 4, -3, -1},
            {-3, -4, 4, -2, -1, 2, 3, -1, 2, 3, 4, 4, -4},
            {-3, -1, -2, 1, 1, -1, -3, -4, -3, 1, -3, 3, -4},
            {2, 4, 4, 4, -3, -3, 1, -1, 3, 4, -1, 1, 4},
            {2, -2, 0, 4, -1, 0, -2, 4, -4, 0, 0, 2, -3},
            {1, 1, -3, 0, -4, -4, -4, -4, 0, -1, -4, -1, 0},
            {3, -1, -3, -3, -3, -2, -1, 4, -1, -2, 4, 2, 3}
        };

        int maxProductPath = s.maxProductPath(grid);
        System.out.println(maxProductPath);
    }

}
