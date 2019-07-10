package com.lyx.leetcode.Array.RotateArray;

/**
 * Created by lyx on 2018/6/5.
 * 189. Rotate Array
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
