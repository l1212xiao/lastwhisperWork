package com.lyx.everyDayTraining.WhenInMT.matrixCellsInDistanceOrder;

/*
1030. 距离顺序排列矩阵单元格
给定四个整数 row ,   cols ,  rCenter 和 cCenter 。有一个 rows x cols 的矩阵，你在单元格上的坐标是 (rCenter, cCenter) 。
返回矩阵中的所有单元格的坐标，并按与 (rCenter, cCenter) 的 距离 从最小到最大的顺序排。你可以按 任何 满足此条件的顺序返回答案。
单元格(r1, c1) 和 (r2, c2) 之间的距离为|r1 - r2| + |c1 - c2|。

示例 1：

输入：rows = 1, cols = 2, rCenter = 0, cCenter = 0
输出：[[0,0],[0,1]]
解释：从 (r0, c0) 到其他单元格的距离为：[0,1]

示例 2：

输入：rows = 2, cols = 2, rCenter = 0, cCenter = 1
输出：[[0,1],[0,0],[1,1],[1,0]]
解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
[[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。

示例 3：

输入：rows = 2, cols = 3, rCenter = 1, cCenter = 2
输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。

提示：

    1 <= rows, cols <= 100
    0 <= rCenter < rows
    0 <= cCenter < cols
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/2/22
 * @description
 */
public class Solution {

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int n = rows * cols;
        int[][] res = new int[n][2];

        List<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[rows][cols];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{rCenter, cCenter});
        visited[rCenter][cCenter] = true;
        while (!queue.isEmpty()) {
            int[] cPoint = queue.pop();
            list.add(cPoint);
            int i = cPoint[0], j = cPoint[1];
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                queue.add(new int[]{i - 1, j});
                visited[i - 1][j] = true;
            }
            if (i + 1 < rows && !visited[i + 1][j]) {
                queue.add(new int[]{i + 1, j});
                visited[i + 1][j] = true;
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                queue.add(new int[]{i, j - 1});
                visited[i][j - 1] = true;
            }
            if (j + 1 < cols && !visited[i][j + 1]) {
                queue.add(new int[]{i, j + 1});
                visited[i][j + 1] = true;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int rows = 2, cols = 3, rCenter = 1, cCenter = 2;
        int[][] res = s.allCellsDistOrder(rows, cols, rCenter, cCenter);
        String deepToString = Arrays.deepToString(res);
        System.out.println(deepToString);
    }


    public int[][] allCellsDistOrderSort(int rows, int cols, int rCenter, int cCenter) {
        int[][] ret = new int[rows * cols][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ret[i * cols + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, (a, b) ->
            (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)) -
                (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter)));
        return ret;
    }

}
