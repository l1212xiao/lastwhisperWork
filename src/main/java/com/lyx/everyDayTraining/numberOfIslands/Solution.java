package com.lyx.everyDayTraining.numberOfIslands;

/**
 * @author lvyunxiao
 * @date 2020/9/9
 * <p>
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    infect(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    public void infect(char[][] grid, int x, int y, int m, int n) {
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || grid[x][y] == '0') {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
            infect(grid, x + 1, y, m, n);
            infect(grid, x - 1, y, m, n);
            infect(grid, x, y + 1, m, n);
            infect(grid, x, y - 1, m, n);
        }
    }

}
