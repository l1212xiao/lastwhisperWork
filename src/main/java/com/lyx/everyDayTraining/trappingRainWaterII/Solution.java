package com.lyx.everyDayTraining.trappingRainWaterII;

/*
407. 接雨水 II
给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
示例：

给出如下 3x6 的高度图:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

返回 4 。
如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。
下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。

建立小根堆，以高度排序，边缘依次入堆，然后弹出，设立最大值，更新最大值，把附近的也加入，依次弹出
 */

import java.util.PriorityQueue;

/**
 * @author lvyunxiao
 * @date 2020/9/18
 */
public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) {
            return 0;
        }
        int hRow = heightMap.length;
        int hCol = heightMap[0].length;
        boolean[][] isEnter = new boolean[hRow][hCol];
        // [heart,x,y]
        // [高度，横坐标，纵坐标] 小根堆
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        // 边缘入堆
        for (int col = 0; col < hCol - 1; col++) {
            isEnter[0][col] = true;
            heap.add(new int[]{heightMap[0][col], 0, col});
        }
        for (int row = 0; row < hRow - 1; row++) {
            isEnter[row][hCol - 1] = true;
            heap.add(new int[]{heightMap[row][hCol - 1], row, hCol - 1});
        }
        for (int col = hCol - 1; col > 0; col--) {
            isEnter[hRow - 1][col] = true;
            heap.add(new int[]{heightMap[hRow - 1][col], hRow - 1, col});
        }
        for (int row = hRow - 1; row > 0; row--) {
            isEnter[row][0] = true;
            heap.add(new int[]{heightMap[row][0], row, 0});
        }

        int water = 0;
        int max = 0;    // 每个node在弹出的时候，如果value更大，更新max，否则max的值维持不变
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            max = Math.max(max, cur[0]);
            int r = cur[1];
            int c = cur[2];
            if (r > 0 && !isEnter[r - 1][c]) {
                water += Math.max(0, max - heightMap[r - 1][c]);
                isEnter[r - 1][c] = true;
                heap.add(new int[]{heightMap[r - 1][c], r - 1, c});
            }
            if (r < hRow - 1 && !isEnter[r + 1][c]) {
                water += Math.max(0, max - heightMap[r + 1][c]);
                isEnter[r + 1][c] = true;
                heap.add(new int[]{heightMap[r + 1][c], r + 1, c});
            }

            if (c > 0 && !isEnter[r][c - 1]) {
                water += Math.max(0, max - heightMap[r][c - 1]);
                isEnter[r][c - 1] = true;
                heap.add(new int[]{heightMap[r][c - 1], r, c - 1});
            }
            if (c < hCol - 1 && !isEnter[r][c + 1]) {
                water += Math.max(0, max - heightMap[r][c + 1]);
                isEnter[r][c + 1] = true;
                heap.add(new int[]{heightMap[r][c + 1], r, c + 1});
            }
        }
        return water;
    }
}
