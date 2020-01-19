package com.lyx.lagouLearning.demo04_recursionAndBacktracking.combinationSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/1/13
 *
 * 在主函数里：
 *
 * 定义一个 results 数组用来保存最终的结果；
 *
 * 调用函数 backtracking，并将初始的情况以及 results 传递进去，这里的初始情况就是从第一个元素开始尝试，而且初始的子集为空。
 * 在 backtracking 函数里：
 * 检查当前的元素总和是否已经超出了目标给定的值，每添加进一个新的元素时，就将它从目标总和中减去；
 * 如果总和已经超出了目标给定值，就立即返回，去尝试其他的数值；
 * 如果总和刚好等于目标值，就把当前的子集添加到结果中。
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        backtracking(candidates, target, 0, new Stack<>(), result);
        return result;
    }

    private void backtracking(int[] candidates, int target, int start, Stack<Integer> solution, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            solution.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i, solution, result);
            solution.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 5}, 8);
        final String s = lists.toString();
        System.out.println(s);
    }
}
