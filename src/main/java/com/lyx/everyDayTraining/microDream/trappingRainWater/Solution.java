package com.lyx.everyDayTraining.microDream.trappingRainWater;

/*
42. 接雨水

给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：

输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

示例 2：

输入：height = [4,2,0,3,2,5]
输出：9


提示：
    n == height.length
    1 <= n <= 2 * 10^4
    0 <= height[i] <= 10^5
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lvyunxiao
 * @date 2022/3/9
 * @description
 */
public class Solution {

    /* 自己想的，思路有误，没办法解决{3,2,1,2}这一段
    public int trap(int[] height) {
        return trap(height, 0);
    }

    public int trap(int[] height, int begin) {
        int trap = 0;
        int len = height.length;
        int n = height.length - begin;
        if (n < 3) {
            return 0;
        }
        int left = begin;
        while (left < len - 2 && height[left] <= height[left + 1]) {
            left++;
        }
        int right = left + 2;
        while (right < len) {
            if (height[right] >= height[left]) {
                trap += getRain(height, left, right);
                trap += trap(height, right);
                break;
            }
            right++;
        }
        return trap;
    }


    private int getRain(int[] height, int left, int right) {
        int total = (right - left - 1) * (Math.min(height[left], height[right]));
        for (int i = left + 1; i < right; i++) {
            total -= height[i];
        }
        return total;
    }
     */

    /*
    动态规划
    对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去 height[i]。
        创建两个长度为 n 的数组 leftMax 和 rightMax。
        对于 0≤i<n，leftMax[i] 表示下标 i 及其左边的位置中，height 的最大高度，rightMax[i] 表示下标 i 及其右边的位置中，height 的最大高度。
     */
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            ans += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return ans;
    }

    /*
    单调栈
    维护一个单调栈，单调栈存储的是下标，满足从栈底到栈顶的下标对应的数组 height 中的元素递减。
     */
    public int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }


    /*
    方法三：双指针
     */
    public int trap3(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // int trap = s.trap(height);
        int trap = s.trap2(height);
        System.out.println(trap);
    }
}
