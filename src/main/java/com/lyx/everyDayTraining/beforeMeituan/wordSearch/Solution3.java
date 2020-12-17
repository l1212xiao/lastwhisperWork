package com.lyx.everyDayTraining.beforeMeituan.wordSearch;

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

/**
 * @author lvyunxiao
 * @date 2020/9/13
 */
public class Solution3 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }

        if (word.charAt(k) != board[i][j]) {
            return false;
        }
        char t = board[i][j];
        board[i][j] = '0';
        if (dfs(board, word, i + 1, j, k + 1)) return true;
        if (dfs(board, word, i - 1, j, k + 1)) return true;
        if (dfs(board, word, i, j + 1, k + 1)) return true;
        if (dfs(board, word, i, j - 1, k + 1)) return true;
        board[i][j] = t;
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
        Solution3 s = new Solution3();

        char[][] board = new char[3][4];
        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'C', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'E'};

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        boolean exist1 = s.exist(board, word1);
        boolean exist2 = s.exist(board, word2);
        boolean exist3 = s.exist(board, word3);

        System.out.println("exist1: " + exist1);
        System.out.println("exist2: " + exist2);
        System.out.println("exist3: " + exist3);

        char[][] boardTest = new char[1][1];
        boardTest[0] = new char[]{'a'};
        String wordTest = "a";
        boolean existTest = s.exist(boardTest, wordTest);
        System.out.println("existTest: " + existTest);

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
