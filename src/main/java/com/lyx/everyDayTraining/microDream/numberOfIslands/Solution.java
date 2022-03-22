package com.lyx.everyDayTraining.microDream.numberOfIslands;

/*
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。

示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1

示例 2：

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3

提示：

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] 的值为 '0' 或 '1'
 */

/**
 * @author lvyunxiao
 * @date 2022/3/4
 * @description
 */
public class Solution {

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    flushLand(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    /*
    private void flushLand(char[][] grid, int i, int j, int m, int n) {
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        if (i - 1 >= 0) {
            flushLand(grid, i - 1, j, m, n);
        }
        if (i + 1 < m) {
            flushLand(grid, i + 1, j, m, n);
        }
        if (j - 1 >= 0) {
            flushLand(grid, i, j - 1, m, n);
        }
        if (j + 1 < n) {
            flushLand(grid, i, j + 1, m, n);
        }
    }
     */

    private void flushLand(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        flushLand(grid, i - 1, j, m, n);
        flushLand(grid, i + 1, j, m, n);
        flushLand(grid, i, j - 1, m, n);
        flushLand(grid, i, j + 1, m, n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        int i = s.numIslands(grid);
        System.out.println(i);
    }

}
