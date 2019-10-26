package com.lyx.leetcode.Array.nextPermutation;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @Classname Solution
 * @Description Solution
 * @Date 2019/10/26
 * <p>
 * https://leetcode-cn.com/problems/next-permutation/
 * <p>
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println();
        solution.nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
