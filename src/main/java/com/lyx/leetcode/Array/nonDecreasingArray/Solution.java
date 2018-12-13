package com.lyx.Array.nonDecreasingArray;

/**
 * Created by lyx on 2018/8/7.
 * 665. 非递减数列
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (count == 0) {
                    return false;
                }
                if (i == 1 || nums[i] > nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
                count--;
            }
        }
        return true;
    }
}
