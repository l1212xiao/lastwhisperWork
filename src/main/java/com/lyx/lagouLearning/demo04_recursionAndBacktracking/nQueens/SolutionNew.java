package com.lyx.lagouLearning.demo04_recursionAndBacktracking.nQueens;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author lvyunxiao
 * @classname Solution2
 * @description Solution2
 * @date 2020/1/19
 */
public class SolutionNew {

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    /**
     * 思考路径：
     * 1. 定位这是backtrack problem
     * 2. 思考决策树的构建过程
     * 3. 思考回溯的模板
     */
    // 决策树的每一层表示棋盘上的每一行；每个节点可以做出的选择是，在该行的任意一列放置一个皇后。
    static class Solution1 {
        List<List<String>> res;

        public List<List<String>> solveNQueens(int n) {
            if (n <= 0) {
                return null;
            }
            res = new LinkedList<>();
            char[][] board = new char[n][n];
            for (char[] chars : board) {
                Arrays.fill(chars, '.');
            }
            backtrack(board, 0);
            return res;
        }

        /**
         * 路径：board中小于row的那些行都已经成功放置了皇后
         * 可选择列表: 第row行的所有列都是放置Q的选择
         * 结束条件: row超过board的最后一行
         *
         * @param board
         * @param row
         */
        private void backtrack(char[][] board, int row) {
            if (row == board.length) {
                res.add(charToString(board));
                return;
            }
            int n = board[row].length;
            for (int col = 0; col < n; col++) {
                if (!isValid(board, row, col)) {
                    continue;
                }
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }

        private boolean isValid(char[][] board, int row, int col) {
            int rows = board.length;
            // check is valid in col
            for (char[] chars : board) if (chars[col] == 'Q') return false;
            // check is valide upright
            for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
                if (board[i][j] == 'Q') return false;
            }
            // check is valide upleft
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') return false;
            }
            return true;
        }

    }

    public static class Solution2 {

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
                if (!isValide(board, row, col)) {
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

        private boolean isValide(char[][] board, int row, int col) {
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

}
