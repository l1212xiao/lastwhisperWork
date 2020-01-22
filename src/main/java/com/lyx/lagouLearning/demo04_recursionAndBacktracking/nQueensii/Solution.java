package com.lyx.lagouLearning.demo04_recursionAndBacktracking.nQueensii;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/1/19
 * <p>
 * https://leetcode-cn.com/problems/n-queens-ii/
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
public class Solution {

    private int count = 0;
    private Set<Integer> colSet = new HashSet<>();
    private Set<Integer> masterSet = new HashSet<>();
    private Set<Integer> slaveSet = new HashSet<>();

    public int totalNQueens(int n) {
        backtrack(n, 0);
        return count;
    }

    private void backtrack(int n, int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isValide(row, col)) {
                continue;
            }
            updateRecords(row, col);
            backtrack(n, row + 1);
            updateRecords(row, col);
        }
    }

    private boolean isValide(int row, int col) {
        return !colSet.contains(col)
                && !masterSet.contains(row - col)
                && !slaveSet.contains(row + col);
    }

    private void updateRecords(int row, int col) {
        if (colSet.contains(col)) {
            colSet.remove(col);
            masterSet.remove(row - col);
            slaveSet.remove(row + col);
        } else {
            colSet.add(col);
            masterSet.add(row - col);
            slaveSet.add(row + col);
        }
    }

    @Test
    public void test() {
        final int i = totalNQueens(8);
        System.out.println(i);
    }
}
