package com.lyx.leetcode.Numbers.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution
 * @Description Solution
 * @Date 2019/9/8
 * @auther lvyunxiao
 * https://leetcode-cn.com/problems/4sum/
 * <p>
 * 思路：
 * 对数组排序；
 * 固定前面两个数；
 * 在固定的数后面使用双指针移动判断，计算四数的和sum，若sum<target，则右移左指针，若sum>target，则左移右指针，移动过程中注意去重；
 * 在遍历固定的数中，也要注意去重；
 * 注意针对特殊情况进行优化，可以节省大量时间。如可先进行逻辑判断，若后面的遍历操作明显是无意义的，则可直接continue或break，具体优化见代码。
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 优化，若i的连续四数之和大于target，后面肯定没有符合题意的组合，直接跳出
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //若i和前三大的数之和都小于target，那i肯定太小，遍历下一个
            if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) {}
                        while (left < right && nums[right] == nums[--right]) {}
                    } else if (sum < target) {
                        //当前四数之和小于target，则右移左指针
                        while (left < right && nums[left] == nums[++left]) {
                        }
                    } else {
                        while (left<right && nums[right] ==nums[--right]) {}
                    }
                }
            }
        }
        return result;
    }
}
