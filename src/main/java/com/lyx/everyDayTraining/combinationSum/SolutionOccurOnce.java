package com.lyx.everyDayTraining.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

 */

/**
 * @author lvyunxiao
 * @date 2020/9/10
 */
public class SolutionOccurOnce {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    public boolean matchPath(List<Integer> list, List<Integer> path) {
        int m = list.size();
        int n = path.size();
        if (m != n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (list.get(i) != path.get(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsPath(List<List<Integer>> ans, List<Integer> path) {
        for (List<Integer> list : ans) {
            if (matchPath(list, path)) {
                return true;
            }
        }
        return false;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> path, int idx) {
        if (target == 0 && !containsPath(ans, path)) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (idx == candidates.length) {
            return;
        }

        // no choice
        dfs(candidates, target, ans, path, idx + 1);
        if (target - candidates[idx] >= 0) {
            // choice
            path.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, path, idx + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        SolutionOccurOnce s = new SolutionOccurOnce();
        List<List<Integer>> lists = s.combinationSum2(candidates, target);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
