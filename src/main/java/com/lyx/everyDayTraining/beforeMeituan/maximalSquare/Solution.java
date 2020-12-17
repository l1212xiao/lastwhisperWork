package com.lyx.everyDayTraining.beforeMeituan.maximalSquare;

/*
221. 最大正方形
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
 */

/**
 * @author lvyunxiao
 * @date 2020/9/30
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] rightOne = new int[row][col];
        int[][] downOne = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                if (j == col - 1) {
                    rightOne[i][j] = matrix[i][j] - '0';
                } else {
                    rightOne[i][j] = matrix[i][j] == '1' ? (1 + rightOne[i][j + 1]) : 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (i == row - 1) {
                    downOne[i][j] = matrix[i][j] - '0';
                } else {
                    downOne[i][j] = matrix[i][j] == '1' ? (1 + downOne[i + 1][j]) : 0;
                }
            }
        }
        int maxEdge = 0;
        int edge = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                edge = Math.min(rightOne[i][j], downOne[i][j]);
                for (int k = i; k < i + edge; k++) {
                    if (rightOne[k][j] < edge) {
                        edge = rightOne[k][j];
                    }
                }
                maxEdge = Math.max(maxEdge, edge);
            }
        }
        return maxEdge * maxEdge;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int maximalSquare = s.maximalSquare(matrix);
        System.out.println(maximalSquare);
    }
}
