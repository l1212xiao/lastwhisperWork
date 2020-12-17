package com.lyx.everyDayTraining.beforeMeituan.maximalRectangle;

/*
85. 最大矩形
给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6

 */

/*
算法

我们可以以常数时间计算出在给定的坐标结束的矩形的最大宽度。
我们可以通过记录每一行中每一个方块连续的“1”的数量来实现这一点。
每遍历完一行，就更新该点的最大可能宽度。通过以下代码即可实现。
if row[i] == '1' row[i] = row[i - 1] + 1 .

一旦我们知道了每个点对应的最大宽度，我们就可以在线性时间内计算出以该点为右下角的最大矩形。
当我们遍历列时，可知从初始点到当前点矩形的最大宽度，就是我们遇到的每个最大宽度的最小值。
我们定义：

maxWidth=min(maxWidth,widthHere)
curArea = maxWidth * (curre***ow - originalRow + 1)
maxArea = max(maxArea, curArea)

对每个点重复这一过程，就可以得到全局最大。

注意，我们预计算最大宽度的方法事实上将输入转化成了一系列的柱状图，每一栏是一个新的柱状图。我们在针对每个柱状图计算最大面积。

作者：LeetCode
链接：https://leetcode-cn.com/problems/maximal-rectangle/solution/zui-da-ju-xing-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */


/**
 * @author lvyunxiao
 * @date 2020/9/24
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        int maxarea = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {

                    // compute the maximum width and update dp with it
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;

                    int width = dp[i][j];

                    // compute the maximum area rectangle with a lower right corner at [i, j]
                    // 以（i，j）做右下角的最大矩形的面积
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(width, dp[k][j]);
                        maxarea = Math.max(maxarea, width * (i - k + 1));
                    }
                }
            }
        }
        return maxarea;
    }

}
