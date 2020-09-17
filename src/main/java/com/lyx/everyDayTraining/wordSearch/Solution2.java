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

/**
 * @author lvyunxiao
 * @date 2020/9/13
 */
public class Solution2 {

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (check(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    if (check(board, visited, newi, newj, s, k + 1)) {
                        return true;
                    }
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    // 作者：LeetCode-Solution
    // 链接：https://leetcode-cn.com/problems/word-search/solution/dan-ci-sou-suo-by-leetcode-solution/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

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
        Solution2 s = new Solution2();

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
