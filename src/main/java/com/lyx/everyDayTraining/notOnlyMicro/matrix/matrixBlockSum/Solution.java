package com.lyx.everyDayTraining.notOnlyMicro.matrix.matrixBlockSum;

/*
1314. 矩阵区域和

给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：

    i - k <= r <= i + k,
    j - k <= c <= j + k 且
    (r, c) 在矩阵内。

示例 1：

输入：mat = [
[1,2,3],
[4,5,6],
[7,8,9]
],
k = 1

输出：[
[12,21,16],
[27,45,33],
[24,39,28]
]

示例 2：

输入：mat = [
[1,2,3],
[4,5,6],
[7,8,9]
],
k = 2

输出：[
[45,45,45],
[45,45,45],
[45,45,45]
]

提示：
    m == mat.length
    n == mat[i].length
    1 <= m, n, k <= 100
    1 <= mat[i][j] <= 100
 */


import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2022/3/16
 * @description
 */
public class Solution {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];

        int[][] sumRowMat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    sumRowMat[i][j] = mat[i][j];
                } else {
                    sumRowMat[i][j] = sumRowMat[i][j - 1] + mat[i][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = (i - k < 0 ? 0 : i - k);
                int r2 = (i + k > m - 1 ? m - 1 : i + k);
                int c1 = (j - k < 0 ? 0 : j - k);
                int c2 = (j + k > n - 1 ? n - 1 : j + k);
                ans[i][j] = getSum(sumRowMat, r1, c1, r2, c2);
            }
        }
        return ans;
    }

    private int getSum(int[][] sumRowMat, int r1, int c1, int r2, int c2) {
        int sum = 0;
        for (int r = r1; r <= r2; r++) {
            int colSum = (c1 == 0 ? 0 : sumRowMat[r][c1 - 1]);
            sum += sumRowMat[r][c2] - colSum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat =
            {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
        int k = 1;

        int[][] matrixBlockSum = s.matrixBlockSum(mat, k);
        System.out.println(Arrays.deepToString(matrixBlockSum));
    }


}
