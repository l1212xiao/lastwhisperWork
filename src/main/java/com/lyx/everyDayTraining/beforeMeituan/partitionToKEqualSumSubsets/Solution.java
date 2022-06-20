package com.lyx.everyDayTraining.beforeMeituan.partitionToKEqualSumSubsets;

/*
698. 划分为k个相等的子集
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

示例 1：
输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。

提示：
1 <= k <= len(nums) <= 16
0 < nums[i] < 10000
 */

import java.util.Arrays;

/**
 * @author lyx
 * @create 2020-10-11 19:24
 */
public class Solution {

    // 排序 + 回溯
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        return search(new int[k], row, nums, target);
    }


    public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break;
        }
        return false;
    }

    // 作者：LeetCode
    // 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/solution/hua-fen-wei-kge-xiang-deng-de-zi-ji-by-leetcode/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        boolean b = s.canPartitionKSubsets(nums, k);
        System.out.println(b);
    }
}
