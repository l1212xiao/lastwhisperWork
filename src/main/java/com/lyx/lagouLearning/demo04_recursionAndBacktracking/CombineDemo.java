package com.lyx.lagouLearning.demo04_recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname CombineDemo
 * @description CombineDemo
 * @date 2020/1/13
 */
public class CombineDemo {

    public static List<List<Integer>> getCombination(int[] candidates, int size) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        backtracking(candidates, new Stack<>(), size, size, result);
        return result;
    }

    private static void backtracking(int[] candidates, Stack<Integer> solution, int size, int rest, List<List<Integer>> result) {
        if (rest < 0) {
            return;
        }
        if (rest == 0) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for (int i = 0; i < size; i++) {
            solution.add(candidates[i]);
            backtracking(candidates, solution, size, rest - 1, result);
            solution.pop();
        }
    }

    public static void main(String[] args) {
        final List<List<Integer>> combination = getCombination(new int[]{1, 2, 3, 4}, 4);
        System.out.println(combination.toString());
        System.out.println();
        System.out.println("size is " + combination.size()); // 256 4^4

    }
}
