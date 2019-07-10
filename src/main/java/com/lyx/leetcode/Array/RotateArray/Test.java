package com.lyx.leetcode.Array.RotateArray;

/**
 * Created by lyx on 2018/6/5.
 */
public class Test {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};

        Solution3 solution = new Solution3();

        solution.rotate(nums, 3);

        for (int x : nums) {
            System.out.print(x + " ");
        }
    }
}
