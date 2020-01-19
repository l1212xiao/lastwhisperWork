package com.lyx.lagouLearning.demo04_recursionAndBacktracking.nQueens;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author lvyunxiao
 * @classname SolutionOwn
 * @description SolutionOwn
 * @date 2020/1/19
 * <p>
 * ref:https://leetcode-cn.com/problems/n-queens/solution/hui-su-suan-fa-xiang-jie-by-labuladong/
 * <p>
 * 下面是两个有用的编程概念。
 * 第一个叫做 约束编程.
 * <p>
 * 它的基本含义是在放置每个皇后以后增加限制。当在棋盘上放置了一个皇后后，立即排除当前行，列和对应的两个对角线。
 * 该过程传递了 约束 从而有助于减少需要考虑情况数。
 * <p>
 * 第二个叫做 回溯法.
 * <p>
 * 我们来想象一下，当在棋盘上放置了几个皇后且不会相互攻击。但是选择的方案不是最优的，
 * 因为无法放置下一个皇后。此时我们该怎么做？回溯。意思是回退一步，来改变最后放置皇后的位置并且接着往下放置。如果还是不行，再 回溯。
 * <p>
 * 在建立算法之前，我们来考虑两个有用的细节。
 * <p>
 * 1.一行只可能有一个皇后且一列也只可能有一个皇后。
 * 这意味着没有必要再棋盘上考虑所有的方格。只需要按列循环即可。
 * 2.对于所有的主对角线有 行号 - 列号 = 常数，对于所有的次对角线有 行号 + 列号 = 常数.
 * 这可以让我们标记已经在攻击范围下的对角线并且检查一个方格 (行号, 列号) 是否处在攻击位置。
 * <p>
 * 复杂度分析
 * <p>
 * 时间复杂度：O(N!). 放置第 1 个皇后有 N 种可能的方法，放置两个皇后的方法不超过 N (N - 2) ，
 * 放置 3 个皇后的方法不超过 N(N - 2)(N - 4) ，以此类推。总体上，时间复杂度为 O}(N!).
 * 空间复杂度：O(N). 需要保存对角线和行的信息。
 */
public class SolutionOwn {

    private static List<String> charToString(char[][] array) {
        List<String> res = new LinkedList<>();
        for (char[] chars : array) {
            res.add(String.valueOf(chars));
        }
        return res;
    }

    /**
     * 优化isValid的查询，通过3个set来分别记录列、主对角线、副对角线上Q的情况，减少迭代的查询
     * Key值：colIndex, [r-c], [r + c] 作为set的key
     */
    private List<List<String>> result = new LinkedList<>();
    private Set<Integer> colSet = new HashSet<>();
    private Set<Integer> masterSet = new HashSet<>();
    private Set<Integer> slaveSet = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board, 0);
        return result;
    }

    /**
     * path: board in [0, row -1]
     * choices for a row : every cols
     * time to end: row == board.length
     *
     * @param board
     * @param row
     */
    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            result.add(charToString(board));
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            if (!isValide(row, col)) {
                continue;
            }
            updateRecords(board, row, col);
            backtrack(board, row + 1);
            updateRecords(board, row, col);
        }
    }

    private void updateRecords(char[][] board, int row, int col) {
        if (colSet.contains(col)) {
            board[row][col] = '.';
            colSet.remove(col);
            masterSet.remove(row - col);
            slaveSet.remove(row + col);
        } else {
            board[row][col] = 'Q';
            colSet.add(col);
            masterSet.add(row - col);
            slaveSet.add(row + col);
        }
    }

    /**
     * 优化isValid的查询，通过3个set来分别记录列、主对角线、副对角线上Q的情况，减少迭代的查询
     * Key值：colIndex, [r-c], [r + c] 作为set的key
     */
    private boolean isValide(int row, int col) {
        return !colSet.contains(col)
                && !masterSet.contains(row - col)
                && !slaveSet.contains(row + col);
    }

    @Test
    public void test() {
        List<List<String>> res = solveNQueens(4);
        for (List<String> list : res) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println("\n");
        }
    }
}