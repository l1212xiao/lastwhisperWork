package com.lyx.everyDayTraining.notOnlyMicro.matrix.matrix01;

/*
给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1：

输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
输出：[[0,0,0],[0,1,0],[0,0,0]]

示例 2：

输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
输出：[[0,0,0],[0,1,0],[1,2,1]]

提示：
    m == mat.length
    n == mat[i].length
    1 <= m, n <= 10^4
    1 <= m * n <= 10^4
    mat[i][j] is either 0 or 1.
    mat 中至少有一个 0

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lvyunxiao
 * @date 2022/3/14
 * @description
 */
public class Solution {

    /*
    有bug，无法解决最近没有可访问元素0的情况
     */
    /*
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        // 表示位置i,j设置
        boolean[][] filled = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    filled[i][j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (filled[i][j]) {
                    continue;
                }
                boolean[][] visited = new boolean[m][n];
                res[i][j] = getMinDis(mat, res, filled, visited, i, j);
                filled[i][j] = true;
            }
        }
        return res;
    }

    private int getMinDis(int[][] mat, int[][] res, boolean[][] filled, boolean[][] visited, int i, int j) {

        int m = mat.length;
        int n = mat[0].length;
        if (mat[i][j] == 0) {
            return 0;
        }
        if (filled[i][j]) {
            return res[i][j];
        }
        visited[i][j] = true;
        List<int[]> needVisited = new ArrayList<>();
        if (i - 1 >= 0 && !visited[i - 1][j]) {
            needVisited.add(new int[]{i - 1, j});
            visited[i - 1][j] = true;
        }
        if (i + 1 < m && !visited[i + 1][j]) {
            needVisited.add(new int[]{i + 1, j});
            visited[i + 1][j] = true;
        }
        if (j - 1 >= 0 && !visited[i][j - 1]) {
            needVisited.add(new int[]{i, j - 1});
            visited[i][j - 1] = true;
        }
        if (j + 1 < n && !visited[i][j + 1]) {
            needVisited.add(new int[]{i, j + 1});
            visited[i][j + 1] = true;
        }

        int min = Integer.MAX_VALUE / 2;
        if (needVisited.isEmpty()) {
            return min;
        }
        for (int[] ele : needVisited) {
            min = Math.min(min, getMinDis(mat, res, filled, visited, ele[0], ele[1]));
        }
        return min + 1;
    }
    */

    // 广度优先遍历 bfs
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    ans[ni][nj] = ans[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
            }
        }

        return ans;
    }


    // 动态规划
    public int[][] updateMatrix2(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // 初始化动态规划的数组，所有的距离值都设置为一个很大的数
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE / 2);
        }
        // 如果 (i, j) 的元素为 0，那么距离为 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                }
            }
        }
        // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
                }
            }
        }
        /*
        // 只有 水平向左移动 和 竖直向下移动，注意动态规划的计算顺序
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m) {
                    ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
                }
            }
        }

        // 只有 水平向右移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (i - 1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
                }
                if (j + 1 < n) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
                }
            }
        }
         */
        // 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // int[][] mat = {
        //     {0, 0, 0},
        //     {0, 1, 0},
        //     {1, 1, 1}
        // };

        int[][] mat = {
            {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
            {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
        };

        int[][] updateMatrix = s.updateMatrix(mat);
        System.out.println(Arrays.deepToString(updateMatrix));
    }


}
