package com.lyx.lagouLearning.domo10_highIII.lc_84;

import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/4/13
 * <p>
 * ref:https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * https://kaiwu.lagou.com/course/courseInfo.htm?courseId=3#/detail/pc?id=86
 * <p>
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 1.一旦我们发现当前的高度要比堆栈顶端所记录的高度要矮，
 * 就可以开始对堆栈顶端记录的高度计算面积了。在这里，
 * 我们巧妙地处理了当i等于n时的情况。同时在这一步里，
 * 我们判断一下当前的面积是不是最大值。
 * <p>
 * 2.如果当前的高度比堆栈顶端所记录的高度要高，就压入堆栈。
 *
 * 时间复杂度是O(n)，因为从头到尾扫描了一遍数组，每个元素都被压入堆栈一次，弹出一次。
 * 空间复杂度是O(n)，因为用了一个堆栈来保存各个元素的下标，最坏的情况就是各个高度按照从矮到高的顺序排列，需要将它们都压入堆栈。
 *
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        // 将输入数组的长度记为 n，初始化最大面积 max 为 0
        int n = heights.length, max = 0;
        // 定义一个堆栈 stack 用来辅助计算
        Stack<Integer> stack = new Stack<>();

        // 从头开始扫描输入数组
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                max = Math.max(max, width * height);
            }
            stack.push(i);
        }
        return max;
    }
}
