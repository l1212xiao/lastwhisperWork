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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ocean {

    int[][] mat;
    int m;
    int n;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    int curCount;
    List<int[]> curPath;
    int[][] ans;

    public int[][] getOceanArea(int[][] mat) {
        this.mat = mat;
        this.m = mat.length;
        this.n = mat[0].length;
        this.visited = new boolean[m][n];

        this.ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.curCount = 0;
                this.curPath = new ArrayList<>();
                if (mat[i][j] == 1 && !visited[i][j]) {
                    backtrack(i, j);
                }
                if (curCount > 0) {
                    for (int[] path : curPath) {
                        ans[path[0]][path[1]] = curCount;
                    }
                }
            }
        }
        return ans;
    }

    private void backtrack(int i, int j) {

        if (i < 0 || i >= m || j < 0 || j >= n || mat[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        curCount++;
        curPath.add(new int[]{i, j});
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            backtrack(ni, nj);
        }
    }

    public static void main(String[] args) {
        Ocean s = new Ocean();
        int[][] mat = {
                {0, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 0, 0, 0}
        };
        int[][] oceanArea = s.getOceanArea(mat);
        String ocean = Arrays.deepToString(oceanArea);
        System.out.println(ocean);
    }


}
