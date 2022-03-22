package com.lyx.everyDayTraining.notOnlyMicro.matrix.longestLineOfConsecutiveOneInMatrix;

/*
562. 矩阵中最长的连续1线段
给定一个 m x n 的二进制矩阵 mat ，返回矩阵中最长的连续1线段。
这条线段可以是水平的、垂直的、对角线的或者反对角线的。

示例 1:

输入: mat = [
[0,1,1,0],
[0,1,1,0],
[0,0,0,1]
]
输出: 3


示例 2:

输入: mat = [
[1,1,1,1],
[0,1,1,0],
[0,0,0,1]
]
输出: 4

提示:
    m == mat.length
    n == mat[i].length
    1 <= m, n <= 104
    1 <= m * n <= 104
    mat[i][j] 不是 0 就是 1.

 */


/**
 * @author lvyunxiao
 * @date 2022/3/16
 * @description
 */
public class Solution {


    /*
    public int longestLine(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int m = mat.length;
        int n = mat[0].length;
        int longestLine = 0;
        int[] rowLine = new int[n];
        int[] colLine = new int[m];

        // 水平方向
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    rowLine[0] = mat[i][j];
                } else if (mat[i][j] == 1) {
                    rowLine[j] = mat[i][j - 1] + 1;
                } else {
                    rowLine[j] = 0;
                }
                longestLine = Math.max(longestLine, rowLine[j]);
            }
        }

        // 垂直方向
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    colLine[0] = mat[i][j];
                } else if (mat[i][j] == 1) {
                    colLine[i] = mat[i - 1][j] + 1;
                } else {
                    colLine[i] = 0;
                }
                longestLine = Math.max(longestLine, colLine[i]);
            }
        }

         // 主对角线和反对角线表示？
        return longestLine;
    }
     */

    /*
    方法一：暴力: 起点+方向

    直接遍历所有的横，竖，对角线，反对角线线段，记录经过的最长的 1 线段。但是如果直接把横，竖，对角线，反对角线的遍历各写一遍，
    代码会非常冗长，难以排错。所以让我们先来研究一下这几种遍历之间有什么共性。
    分析可知，要遍历任意一条线段，我们只需要给出这条线段的起点，以及遍历方向，然后让线段从起点开始，
    一直向遍历方向走到矩阵的边界为起点即可。无论是横，竖，对角线，还是反对角线的遍历，都遵从上述的逻辑，只是起点与方向有所不同。
    接着，我们来列举一下需要考虑的起点和方向：

    对于横向的线段，遍历方向是向右，可能的起点是矩阵的左边界为起点的所有点。
    对于纵向的线段，遍历方向是向下，可能的起点是矩阵的上边界为起点的所有点。
    对于对角线方向的线段，遍历方向是向下向右，可能的起点是矩阵的上边界为起点的所有点，以及左边界的所有点。
    对于反对角线方向的线段，遍历方向是向下向左，可能的起点是矩阵的上边界为起点的所有点，以及右边界的所有点。
    那我们只需要遍历这些可能的起点，并指定方向进行同样逻辑的计数即可。
    */
    public boolean overflow(int[][] mat, int i, int j) {
        return i < 0 || j < 0 || i >= mat.length || j >= mat[0].length;
    }

    public int count(int[][] mat, int i, int j, int di, int dj) {
        int ans = 0, cur = 0;
        while (!overflow(mat, i, j)) {
            if (mat[i][j] == 1) {
                cur++;
                ans = Math.max(ans, cur);
            } else {
                cur = 0;
            }
            i += di;
            j += dj;
        }
        return ans;
    }

    public int longestLine(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            // 左边界为起点，向右
            ans = Math.max(ans, count(mat, i, 0, 0, 1));
            // 左边界为起点，向右下
            ans = Math.max(ans, count(mat, i, 0, 1, 1));
            // 右边界为起点，向左下
            ans = Math.max(ans, count(mat, i, n - 1, 1, -1));
        }
        for (int j = 0; j < n; j++) {
            // 上边界为起点，向下
            ans = Math.max(ans, count(mat, 0, j, 1, 0));
            // 上边界为起点，向右下
            ans = Math.max(ans, count(mat, 0, j, 1, 1));
            // 上边界为起点，向左下
            ans = Math.max(ans, count(mat, 0, j, 1, -1));
        }
        return ans;
    }


}
