package com.lyx.everyDayTraining.notOnlyMicro.subsets;

/*
78. 子集

给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

示例 2：

输入：nums = [0]
输出：[[],[0]]

提示：
    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    nums 中的所有元素 互不相同
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/4/6
 * @description
 */
public class Solution {

    // 方法一：迭代法实现子集枚举
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            path.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    path.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(path));
        }
        return ans;
    }

    // 方法二：递归法实现子集枚举
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, path, ans);
        return ans;
    }

    private void dfs(int cur, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 遇到下标为第cur个数字，取还是不取
        // 取
        path.add(nums[cur]);
        dfs(cur + 1, nums, path, ans);

        // 不取
        path.remove(path.size() - 1);
        dfs(cur + 1, nums, path, ans);
    }

}
