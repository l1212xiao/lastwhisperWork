package com.lyx.everyDayTraining.beforeMeituan.editDistance;

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

 */

/**
 * @author lvyunxiao
 * @date 2020/9/21
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length() + 1;
        int n2 = word2.length() + 1;
        int[][] dp = new int[n1][n2];
        char[] charArr1 = word1.toCharArray();
        char[] charArr2 = word2.toCharArray();
        for (int i = 0; i < n1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (charArr1[i - 1] == charArr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];    //copy
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;    //edit
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);    //insert
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);    //delete
            }
        }
        return dp[n1 - 1][n2 - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String word1 = "horse", word2 = "ros";
        int i = s.minDistance(word1, word2);
        System.out.println(i);
    }
}
