package com.lyx.everyDayTraining.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]

 */

/**
 * @author lvyunxiao
 * @date 2020/9/11
 * <p>
 * 216. 组合总和 III
 */
public class SolutionSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(k, n, ans, new ArrayList<>(), 1);
        return ans;
    }

    public void dfs(int k, int n, List<List<Integer>> ans, List<Integer> path, int begin) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (k < 0 || begin > 9) {
            return;
        }
        // no choice
        dfs(k, n, ans, path, begin + 1);

        //choice
        if (n - begin >= 0) {
            path.add(begin);
            dfs(k - 1, n - begin, ans, path, begin + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        SolutionSumIII s = new SolutionSumIII();
        int k = 3;
        int n = 7;
        List<List<Integer>> lists = s.combinationSum3(k, n);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
