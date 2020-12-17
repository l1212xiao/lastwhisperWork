package com.lyx.everyDayTraining.beforeMeituan.combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/9/9
 * <p>
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * <p>
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */

// can't ac
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int[] used = new int[candidates.length];
        backtrack(candidates, target, used, 0, res);
        return res;
    }

    public int getSum(int[] candidates, int[] used) {
        int len = candidates.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int usedNum = used[i];
            for (int j = 0; j < usedNum; j++) {
                sum += candidates[i];
            }
        }
        return sum;
    }

    public void backtrack(int[] candidates, int target, int[] used, int start, List<List<Integer>> res) {
        if (getSum(candidates, used) > target) {
            return;
        }

        if (getSum(candidates, used) == target) {
            List<Integer> collet = new ArrayList<>();
            for (int i = 0; i < candidates.length; i++) {
                int usedNum = used[i];
                for (int j = 0; j < usedNum; j++) {
                    collet.add(candidates[i]);
                }
            }
            res.add(collet);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            while (getSum(candidates, used) < target) {
                backtrack(candidates, target, used, start + 1, res);
                used[i] += 1;
            }
        }
    }
}
