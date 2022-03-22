package com.lyx.everyDayTraining.notOnlyMicro.matrix.reshapeTheMatrix;

/*
566. 重塑矩阵

在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。

示例 1：

输入：mat = [[1,2],[3,4]], r = 1, c = 4
输出：[[1,2,3,4]]

示例 2：

输入：mat = [[1,2],[3,4]], r = 2, c = 4
输出：[[1,2],[3,4]]

提示：
    m == mat.length
    n == mat[i].length
    1 <= m, n <= 100
    -1000 <= mat[i][j] <= 1000
    1 <= r, c <= 300

 */


import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2022/3/15
 * @description
 */
public class Solution {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int total = m * n;
        if (r * c != total) {
            return mat;
        }
        int[][] ans = new int[r][c];
        for (int e = 0; e < total; e++) {
            int i = e / n;
            int j = e % n;
            int ni = e / c;
            int nj = e % c;
            ans[ni][nj] = mat[i][j];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1, c = 4;

        int[][] matrixReshape = s.matrixReshape(mat, r, c);
        System.out.println(Arrays.deepToString(matrixReshape));

    }

}
