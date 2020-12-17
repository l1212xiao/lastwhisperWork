package com.lyx.everyDayTraining.beforeMeituan.spiralMatrixII;

/*
59. 螺旋矩阵 II
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

import java.util.Arrays;

/**
 * @date 2020-9-23
 */
public class Solution {
    int curNum = 1;

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int len = n - 1;
        for (int i = 0; i < n; i++) {
            addEdge(ans, n, len--, i, i);
        }
        return ans;
    }

    private void addEdge(int[][] ans, int n, int len, int curR, int curC) {
        while (curNum <= n * n) {
            while (curC < len) {
                ans[curR][curC++] = curNum++;
            }
            while (curR < len) {
                ans[curR++][curC] = curNum++;
            }
            while (curC > 0) {
                ans[curR][curC--] = curNum++;
            }
            while (curR > 0) {
                ans[curR--][curC] = curNum++;
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] generateMatrix = s.generateMatrix(3);
        for (int i = 0; i < generateMatrix.length; i++) {
            System.out.println(Arrays.toString(generateMatrix[i]));
        }
    }
}
