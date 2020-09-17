package com.lyx.everyDayTraining.wordSearch;

/*
79. 单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/9/13
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        return dfs(board, word, new ArrayList<>(), m, n);
    }

    public boolean checkMatch(char[][] board, String word, List<String> used, int m, int n, int x, int y) {
        if (word.length() == 0) {
            return true;
        }

        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }

        if (board[x][y] == word.charAt(0) && !used.contains(String.valueOf(x) + y)) {
            used.add(String.valueOf(x) + y);
            if (checkMatch(board, word.substring(1), used, m, n, x + 1, y)
                    || checkMatch(board, word.substring(1), used, m, n, x - 1, y)
                    || checkMatch(board, word.substring(1), used, m, n, x, y + 1)
                    || checkMatch(board, word.substring(1), used, m, n, x, y - 1)) {
                return true;
            } else {
                used.remove(used.size() - 1);
                return false;
            }
        } else {
            return false;
        }
    }

    // List<String> used "xy" for used
    public boolean dfs(char[][] board, String word, List<String> used, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checkMatch(board, word, used, m, n, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*
        [
            ['A','B','C','E'],
            ['S','F','C','S'],
            ['A','D','E','E']
        ]
            给定 word = "ABCCED", 返回 true
            给定 word = "SEE", 返回 true
            给定 word = "ABCB", 返回 false
         */

        /*
        [["a","b"]]
        "ba"
        预期结果：true
         */
        Solution s = new Solution();

        char[][] board = new char[3][4];
        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'C', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'E'};

        // String word1 = "ABCCED";
        // String word2 = "SEE";
        String word3 = "ABCB";

        // boolean exist1 = s.exist(board, word1);
        // boolean exist2 = s.exist(board, word2);
        boolean exist3 = s.exist(board, word3);

        // System.out.println("exist1: " + exist1);
        // System.out.println("exist2: " + exist2);
        System.out.println("exist3: " + exist3);

        // char[][] boardTest = new char[1][1];
        // boardTest[0] = new char[]{'a'};
        // String wordTest = "a";
        // boolean existTest = s.exist(boardTest, wordTest);
        // System.out.println("existTest: " + existTest);

        /*
        [["C","A","A"],["A","A","A"],["B","C","D"]]
        "AAB"
         */
        // char[][] boardTest = new char[3][3];
        // boardTest[0] = new char[]{'C', 'A', 'A'};
        // boardTest[1] = new char[]{'A', 'A', 'A'};
        // boardTest[2] = new char[]{'B', 'C', 'D'};
        // String wordTest = "AAB";
        // boolean existTest = s.exist(boardTest, wordTest);
        // System.out.println("existTest: " + existTest);

    }

}
