package com.lyx.everyDayTraining.WhenInMT.increasingTripletSubsequence;

/*
334. 递增的三元子序列
给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。

如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
示例 1：

输入：nums = [1,2,3,4,5]
输出：true
解释：任何 i < j < k 的三元组都满足题意
示例 2：

输入：nums = [5,4,3,2,1]
输出：false
解释：不存在满足题意的三元组
示例 3：

输入：nums = [2,1,5,0,4,6]
输出：true
解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6


提示：

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1

 */


/**
 * @author lvyunxiao
 * @date 2022/1/12
 * @description
 */
public class Solution {

    // O(3) 超时
    // public boolean increasingTriplet(int[] nums) {
    //     int n = nums.length;
    //     if (n < 3) {
    //         return false;
    //     }
    //     for (int i = 0; i < n - 2; i++) {
    //         for (int j = i + 1; j < n - 1; j++) {
    //             if (nums[i] >= nums[j]) {
    //                 break;
    //             } else {
    //                 for (int k = j + 1; k < n; k++) {
    //                     if (nums[j] < nums[k]) {
    //                         return true;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        // 创建两个长度为 n 的数组 leftMin 和 rightMax，对于 0 ≤ i < n，leftMin[i] 表示 nums[0] 到 nums[i] 中的最小值，
        // rightMax[i] 表示 nums[i] 到 nums[n−1] 中的最大值。

        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int[] nums = {2, 1, 5, 0, 4, 6};
        int[] nums = {5, 4, 3, 2, 1};
        boolean increasingTriplet = s.increasingTriplet(nums);
        System.out.println(increasingTriplet);

    }


}
