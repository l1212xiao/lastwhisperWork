package com.lyx.everyDayTraining.spiralMatrix;

/*
54. 螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/9/18
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        int mRow = matrix.length - 1;
        int mCol = matrix[0].length - 1;
        int i = 0;
        int j = 0;
        while (i <= mRow && j <= mCol) {
            getEdge(matrix, ans, i++, j++, mRow--, mCol--);
        }
        return ans;
    }

    public void getEdge(int[][] matrix, List<Integer> ans, int i, int j, int mRow, int mCol) {
        if (i == mRow) {
            for (int col = i; col <= mCol; col++) {
                ans.add(matrix[i][col]);
            }
        } else if (j == mCol) {
            for (int row = j; row <= mRow; row++) {
                ans.add(matrix[row][j]);
            }
        } else {
            int curR = i;
            int curC = j;
            while (curC != mCol) {
                ans.add(matrix[curR][curC]);
                curC++;
            }
            while (curR != mRow) {
                ans.add(matrix[curR][curC]);
                curR++;
            }
            while (curC != i) {
                ans.add(matrix[curR][curC]);
                curC--;
            }
            while (curR != i) {
                ans.add(matrix[curR][curC]);
                curR--;
            }
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] m = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        List<Integer> spiralOrder = s.spiralOrder(m);
        System.out.println(spiralOrder.toString());
        // System.out.println(Arrays.toString(spiralOrder.toArray()));
    }

}
