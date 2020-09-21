package com.lyx.everyDayTraining.trappingRainWater;

/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水
（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 */

/**
 * @author lvyunxiao
 * @date 2020/9/18
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int n = height.length;
        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftMax = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            water += Math.max(0, Math.min(leftMax, rightMax) - height[i]);
        }
        return water;
    }

    public int trap2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int n = height.length;
        int leftMax = height[0];
        int l = 1;
        int rightMax = height[n - 1];
        int r = n - 2;
        int water = 0;
        while (l <= r) {
            if (leftMax <= rightMax) {
                water += Math.max(0, leftMax - height[l]);
                leftMax = Math.max(leftMax, height[l++]);
            } else {
                water += Math.max(0, rightMax - height[r]);
                rightMax = Math.max(rightMax, height[r--]);
            }
        }
        return water;
    }

}
