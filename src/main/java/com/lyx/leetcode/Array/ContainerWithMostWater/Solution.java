package com.lyx.Array.ContainerWithMostWater;

/**
 * Created by lyx on 2018/7/5.
 */
public class Solution {
    public int maxArea(int[] height) {
        int maxA = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
                maxA = maxA > area ? maxA : area;
            }
        }
        return maxA;
    }
}
