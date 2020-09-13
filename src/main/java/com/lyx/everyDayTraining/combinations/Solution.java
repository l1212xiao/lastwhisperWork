package com.lyx.everyDayTraining.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/9/8
 * <p>
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/combinations
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, res, new ArrayList<>());
        return res;
    }

    public void backtrack(int n, int k, int start, List<List<Integer>> res, List<Integer> path) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k - 1, i + 1, res, path);
            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4, k = 2;
        List<List<Integer>> combine = solution.combine(n, k);
        Object[] objects = combine.toArray();
        String toString = Arrays.deepToString(objects);
        System.out.println(toString);
    }
}
