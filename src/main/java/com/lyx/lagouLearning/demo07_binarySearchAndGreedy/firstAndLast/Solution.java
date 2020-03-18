package com.lyx.lagouLearning.demo07_binarySearchAndGreedy.firstAndLast;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/6
 * 34:https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLowerBound(nums, target, 0, nums.length - 1),
                searchUpperBound(nums, target, 0, nums.length - 1)};
    }

    private int searchLowerBound(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        // 判断是否为下边界时，先看mid的数据是否为target，并且该数为第一个数，或者，之前的数比它小
        if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {
            return mid;
        }
        if (target <= nums[mid]) {
            return searchLowerBound(nums, target, low, mid - 1);
        } else {
            return searchLowerBound(nums, target, mid + 1, high);
        }
    }

    private int searchUpperBound(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        // 判断是否为上边界时，先看mid的数据是否为target，并且该数为最后欧一个数，或者，之后的数比它大
        if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)) {
            return mid;
        }
        if (target < nums[mid]) {
            return searchUpperBound(nums, target, low, mid - 1);
        } else {
            return searchUpperBound(nums, target, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        Solution solutions = new Solution();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] searchRange = solutions.searchRange(nums, target);
        System.out.println(Arrays.toString(searchRange));
    }

}
