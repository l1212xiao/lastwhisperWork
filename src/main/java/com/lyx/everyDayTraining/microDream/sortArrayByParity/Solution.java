package com.lyx.everyDayTraining.microDream.sortArrayByParity;

/*
905. 按奇偶排序数组

给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
返回满足此条件的 任一数组 作为答案。

示例 1：

输入：nums = [3,1,2,4]
输出：[2,4,3,1]
解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。

示例 2：

输入：nums = [0]
输出：[0]

提示：
    1 <= nums.length <= 5000
    0 <= nums[i] <= 5000
 */


import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2022/4/28
 * @description
 */
public class Solution {

    // 方法三：双指针 + 原地交换
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        int left = 0, right = n - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    // 方法一：两次遍历
    public int[] sortArrayByParity1(int[] nums) {
        int n = nums.length, index = 0;
        int[] res = new int[n];
        for (int num : nums) {
            if (num % 2 == 0) {
                res[index++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 == 1) {
                res[index++] = num;
            }
        }
        return res;
    }

    // 方法二：双指针 + 一次遍历
    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] res = new int[n];
        for (int num : nums) {
            if (num % 2 == 0) {
                res[left++] = num;
            } else {
                res[right--] = num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        Solution s = new Solution();

        int[] sortArrayByParity = s.sortArrayByParity(nums);
        System.out.println(Arrays.toString(sortArrayByParity));
    }
}
