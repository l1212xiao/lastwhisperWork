package com.lyx.everyDayTraining.notOnlyMicro.matrix.sortedMatrixSearchLcci;

/*
面试题 10.09. 排序矩阵查找

给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

给定 target = 5，返回 true。

给定 target = 20，返回 false。

 */


/**
 * @author lvyunxiao
 * @date 2022/3/16
 * @description
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }


}
