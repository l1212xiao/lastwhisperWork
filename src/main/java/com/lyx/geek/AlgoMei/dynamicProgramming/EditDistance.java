package com.lyx.geek.AlgoMei.dynamicProgramming;

/*
72. 编辑距离
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
    插入一个字符
    删除一个字符
    替换一个字符

示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例 2：

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

提示：
    0 <= word1.length, word2.length <= 500
    word1 和 word2 由小写英文字母组成
 */


/**
 * @author lvyunxiao
 * @date 2021/8/12
 * @description
 */
public class EditDistance {

    /*
    [LC.72] 编辑距离
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int down = dp[i][j - 1] + 1;
                int left = dp[i - 1][j] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(left, down), leftDown);
                } else {
                    dp[i][j] = Math.min(Math.min(left, down), leftDown + 1);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        // 输入：word1 = "horse", word2 = "ros"
        EditDistance s = new EditDistance();
        // String word1 = "horse", word2 = "ros";
        String word1 = "a", word2 = "b";
        int minDistance = s.minDistance(word1, word2);
        System.out.println(minDistance);
    }

}
