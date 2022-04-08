package com.lyx.everyDayTraining.notOnlyMicro.subsetsIi;

/*
90. 子集 II
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

示例 2：

输入：nums = [0]
输出：[[],[0]]

提示：
    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/4/2
 * @description
 */
public class Solution {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            path.clear();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    path.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<>(path));
            }
        }
        return ans;
    }

    // 方法二：递归法实现子集枚举
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(false, 0, nums, path, ans);
        return ans;
    }

    private void dfs(boolean choosePre, int cur, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 遇到下标为第cur个数字，取还是不取

        // 不取
        dfs(false, cur + 1, nums, path, ans);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }

        // 取
        path.add(nums[cur]);
        dfs(true, cur + 1, nums, path, ans);
        path.remove(path.size() - 1);
    }

}
