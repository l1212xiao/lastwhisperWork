package com.lyx.leetcode.Array.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyx on 2018/7/5.
 * 15. 3Sum
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int begin = i + 1;
            int end = nums.length - 1;

            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[begin]);
                    list.add(nums[end]);
                    result.add(list);
                    begin++;
                    end--;

                    while (begin < end && nums[begin] == nums[begin - 1]) {
                        begin++;
                    }
                    while (begin < end && nums[end] == nums[end + 1]) {
                        end--;
                    }

                } else if (sum > 0) {
                    end--;
                } else {
                    begin++;
                }
            }
        }
        return result;
    }
}
