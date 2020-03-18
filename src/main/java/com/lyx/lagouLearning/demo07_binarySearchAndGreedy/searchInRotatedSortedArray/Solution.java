package com.lyx.lagouLearning.demo07_binarySearchAndGreedy.searchInRotatedSortedArray;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/6
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Solution {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[low] <= nums[mid]) {
            // 左边有序
            if (target >= nums[low] && target <= nums[mid]) {
                return search(nums, target, low, mid - 1);
            } else {
                return search(nums, target, mid + 1, high);
            }
        } else {
            // 右边有序
            if (target > nums[mid] && target <= nums[high]) {
                return search(nums, target, mid + 1, high);
            } else {
                return search(nums, target, low, mid - 1);
            }
        }
    }
}
