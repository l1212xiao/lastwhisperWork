package com.lyx.everyDayTraining.beforeMeituan.largestRectangleInHistogram;

/*
84. 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
示例:

输入: [2,1,5,6,2,3]
输出: 10
 */


/**
 * @author lvyunxiao
 * @date 2020/9/24
 */
public class Solution {

    // 按照高度进行限制
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int curHeight = heights[i];
            int left = i;
            int right = i;
            while (right + 1 < n && heights[right + 1] >= curHeight) {
                right++;
            }
            while (left - 1 >= 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            maxArea = Math.max(maxArea, curHeight * (right - left + 1));
        }
        return maxArea;
    }

    // 按照宽度进行限制
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int maxArea = 0;
        for (int left = 0; left < n; left++) {
            int minHeight = Integer.MAX_VALUE;
            for (int right = left; right < n; right++) {
                minHeight = Math.min(minHeight, heights[right]);
                maxArea = Math.max(maxArea, minHeight * (right - left + 1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {2, 1, 2};
        int largestRectangleArea = s.largestRectangleArea(heights);
        System.out.println(largestRectangleArea);
    }
}
