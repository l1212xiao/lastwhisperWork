package com.lyx.everyDayTraining.microDream.spiralMatrix;

/*
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

提示：
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10
    -100 <= matrix[i][j] <= 100

 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/3/4
 * @description
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int aR = 0;
        int bR = matrix.length - 1;
        int aC = 0;
        int bC = matrix[0].length - 1;
        while (aR <= bR && aC <= bC) {
            addSpiralOrder(matrix, ans, aR++, bR--, aC++, bC--);
        }
        return ans;
    }

    private void addSpiralOrder(int[][] matrix, List<Integer> ans, int aR, int bR, int aC, int bC) {
        if (aR == bR) {
            for (int i = aC; i <= bC; i++) {
                ans.add(matrix[aR][i]);
            }
        } else if (aC == bC) {
            for (int i = aR; i <= bR; i++) {
                ans.add(matrix[i][aC]);
            }
        } else {
            int curR = aR;
            int curC = aC;
            while (curC != bC) {
                ans.add(matrix[aR][curC]);
                curC++;
            }
            while (curR != bR) {
                ans.add(matrix[curR][bC]);
                curR++;
            }
            while (curC != aC) {
                ans.add(matrix[bR][curC]);
                curC--;
            }
            while (curR != aR) {
                ans.add(matrix[curR][aC]);
                curR--;
            }
        }
    }

    private List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;
    }


}
