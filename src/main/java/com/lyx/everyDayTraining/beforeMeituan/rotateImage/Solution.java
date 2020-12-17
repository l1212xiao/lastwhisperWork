package com.lyx.everyDayTraining.beforeMeituan.rotateImage;

/*
48. 旋转图像
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

 */


import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2020/9/27
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        while (l < r && t < b) {
            rorateEdge(matrix, l++, r--, t++, b--);
        }
    }

    public void rorateEdge(int[][] matrix, int cStart, int cEnd, int rStart, int rEnd) {
        for (int i = 0; i < cEnd - cStart; i++) {
            int tmp = matrix[rStart][cStart + i];
            matrix[rStart][cStart + i] = matrix[rEnd - i][cStart];
            matrix[rEnd - i][cStart] = matrix[rEnd][cEnd - i];
            matrix[rEnd][cEnd - i] = matrix[rStart + i][cEnd];
            matrix[rStart + i][cEnd] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        // int[][] matrix = {
        //         { 5, 1, 9,11},
        //         { 2, 4, 8,10},
        //         {13, 3, 6, 7},
        //         {15,14,12,16}
        // };
        // int[][] matrix = {
        //         {2,29,20,26,16,28},
        //         {12,27,9,25,13,21},
        //         {32,33,32,2,28,14},
        //         {13,14,32,27,22,26},
        //         {4,24,1,6,32,34}
        // };
        //[[2,29,20,26,16,28],[12,27,9,25,13,21],[32,33,32,2,28,14],[13,14,32,27,22,26],[33,1,20,7,21,7],[4,24,1,6,32,34]]

        printMatrix(matrix);
        s.rotate(matrix);
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("========start=========");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("=========end ========");
    }
}
