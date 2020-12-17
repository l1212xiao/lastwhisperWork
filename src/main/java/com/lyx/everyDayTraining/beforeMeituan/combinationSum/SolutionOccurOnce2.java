package com.lyx.everyDayTraining.beforeMeituan.combinationSum;

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
public class SolutionOccurOnce2 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, target, path, 0);
        return ans;
    }

    private void backtrack(int[] candidates, int rest, List<Integer> path, int begin) {
        if (rest == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (rest - candidates[i] >= 0) {
                path.add(candidates[i]);
                backtrack(candidates, rest - candidates[i], path, i + 1);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        SolutionOccurOnce2 s = new SolutionOccurOnce2();
        List<List<Integer>> lists = s.combinationSum2(candidates, target);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
