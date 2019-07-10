package com.lyx.leetcode.Array.ThreeSumClosest;

import java.util.Arrays;

/**
 * Created by lyx on 2018/7/5.
 * 16. 3Sum Closest
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int closestSum = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int tempSum = nums[i] + nums[left] + nums[right];
                int tempDiff = Math.abs(tempSum - target);

                if (tempDiff < diff) {
                    closestSum = tempSum;
                    diff = tempDiff;
                }

                if (tempSum < target) {
                    left++;
                } else if (tempSum > target) {
                    right--;
                } else {
                    return tempSum;
                }
            }
        }
        return closestSum;

    }
}
