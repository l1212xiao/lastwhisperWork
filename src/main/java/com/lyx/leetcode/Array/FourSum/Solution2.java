package com.lyx.leetcode.Array.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lyx on 2018/7/5.
 */
public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);
        return findKSumInOrderArray(nums, 0, 4, target);

    }

    public List<List<Integer>> findKSumInOrderArray(int[] nums, int begin, int count, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        HashSet<Integer> visited = new HashSet<Integer>();

        if (count == 2) {
            int f = begin, r = nums.length - 1;
            while (f < r) {
                int sum = nums[f] + nums[r];
                if ((sum == target) && (!visited.contains(nums[f]))) {
                    List<Integer> tuple = new ArrayList<Integer>();
                    tuple.add(nums[f]);
                    tuple.add(nums[r]);
                    visited.add(nums[f]);
                    visited.add(nums[r]);
                    res.add(tuple);
                    ++f;
                    --r;
                } else if (sum < target) {
                    ++f;
                } else {
                    --r;
                }
            }

        } else {

            for (int i = begin; i < nums.length; ++i) {
                if (!visited.contains(nums[i])) {
                    visited.add(nums[i]);
                    List<List<Integer>> subset = new ArrayList<List<Integer>>();
                    subset = findKSumInOrderArray(nums, i + 1, count - 1, target - nums[i]);
                    if (!subset.isEmpty()) {
                        for (int j = 0; j < subset.size(); ++j) {
                            List<Integer> tmp = subset.get(j);
                            tmp.add(0, nums[i]);
                        }

                        res.addAll(subset);
                    }
                }
            }

        }
        return res;
    }

}
