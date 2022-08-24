package com.lyx.everyDayTraining.whenFun;

/*
0表示海洋，1表示陆地
找出相连陆地面积

如
输入
0001
1101
1000

输出
0002
3302
3000

 */

public class MaxArea {

    int[][] grid;
    int m;
    int n;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    int curCount;
    int ans;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];
        this.ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.curCount = 0;
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }

            }
        }
        return ans;
    }

    private void bfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        curCount++;
        ans = Math.max(ans, curCount);
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            bfs(ni, nj);
        }
    }

    public static void main(String[] args) {
        MaxArea s = new MaxArea();
        int[][] mat = {
                {0, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 0, 0, 0}
        };
        int oceanArea = s.maxAreaOfIsland(mat);
        System.out.println(oceanArea);
    }




}
