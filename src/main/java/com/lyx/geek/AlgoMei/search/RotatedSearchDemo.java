package com.lyx.geek.AlgoMei.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lvyunxiao
 * @date 2021/7/15
 * @description
 */
public class RotatedSearchDemo {

    @Test
    public void searchTest() {
        RotatedSearchDemo r = new RotatedSearchDemo();
        // int[] nums = {4, 5, 6, 7, 0, 1, 2};
        // int target = 0;
        int[] nums = {5, 1, 3};
        int target = 1;

        int index = r.search(nums, target);
        Assert.assertEquals(index, 4);
    }

    // [LC.33] 搜索旋转排序数组
    // nums = [4,5,6,7,0,1,2], target = 0
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}
