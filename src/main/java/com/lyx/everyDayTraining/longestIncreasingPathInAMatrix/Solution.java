package com.lyx.everyDayTraining.longestIncreasingPathInAMatrix;

/*
329. 矩阵中的最长递增路径
给定一个整数矩阵，找出最长递增路径的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

示例 1:

输入: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
输出: 4
解释: 最长递增路径为 [1, 2, 6, 9]。
示例 2:

输入: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
输出: 4
解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 */

import java.util.Arrays;

/**
 * @auther lvyunxiao
 * @date 2020-09-20
 */
public class Solution {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int rows, columns;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;

        // 以i，j位置开始的最大长度
        int[][] dp = new int[rows][columns];
        int maxLen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maxLen = Math.max(dfs(matrix, i, j, dp), maxLen);
            }
        }
        return maxLen;
    }

    public int dfs(int[][] matrix, int curRow, int curCol, int[][] dp) {
        if (dp[curRow][curCol] != 0) {
            return dp[curRow][curCol];
        }
        dp[curRow][curCol]++;
        for (int[] dir : dirs) {
            int newRow = curRow + dir[0];
            int newCol = curCol + dir[1];
            if (newRow >= 0 && newRow < rows
                    && newCol >= 0 && newCol < columns
                    && matrix[newRow][newCol] > matrix[curRow][curCol]) {
                dp[curRow][curCol] = Math.max(dp[curRow][curCol], dfs(matrix, newRow, newCol, dp) + 1);
            }
        }
        return dp[curRow][curCol];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] m = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        int longestIncreasingPath = s.longestIncreasingPath(m);
        System.out.println("====================");
        System.out.println(longestIncreasingPath);
    }

}
