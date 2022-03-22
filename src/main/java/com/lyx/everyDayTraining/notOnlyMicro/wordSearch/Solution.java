package com.lyx.everyDayTraining.notOnlyMicro.wordSearch;

/*
79. 单词搜索

给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例 1：

输入：board = [
["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]
],

word = "ABCCED"
输出：true

示例 2：

输入：board = [
["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]
],

word = "SEE"
输出：true

示例 3：

输入：board = [
["A","B","C","E"],
["S","F","C","S"],
["A","D","E","E"]
],

word = "ABCB"
输出：false


提示：
    m == board.length
    n = board[i].length
    1 <= m, n <= 6
    1 <= word.length <= 15
    board 和 word 仅由大小写英文字母组成

 */


/**
 * @author lvyunxiao
 * @date 2022/3/15
 * @description
 */
public class Solution {

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 以board中的(i，j)位置开头的，且能匹配word
    private boolean exist(char[][] board, String word, int i, int j, boolean[][] visited) {
        if (board[i][j] != word.charAt(0)) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }
        boolean result = false;
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + dirs[d][0];
            int nj = j + dirs[d][1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length && !visited[ni][nj]) {
                if (exist(board, word.substring(1), ni, nj, visited)) {
                    result = true;
                    break;
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        // String word = "A";
        // String substring = word.substring(1);
        // System.out.println(substring.length()); // 0

        Solution s = new Solution();

        // char[][] board =
        //     {
        //         {'A', 'B', 'C', 'E'},
        //         {'S', 'F', 'C', 'S'},
        //         {'A', 'D', 'E', 'E'}
        //     };
        // String word = "ABCCED";

        // char[][] board = {
        //     {'A', 'B', 'C', 'E'},
        //     {'S', 'F', 'C', 'S'},
        //     {'A', 'D', 'E', 'E'}
        // };
        // String word = "ABCB";

        // char[][] board = {
        //     {'C', 'A', 'A'},
        //     {'A', 'A', 'A'},
        //     {'B', 'C', 'D'}
        // };
        // String word = "AAB";

        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'E', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";

        boolean exist = s.exist(board, word);
        System.out.println(exist);

    }

}
