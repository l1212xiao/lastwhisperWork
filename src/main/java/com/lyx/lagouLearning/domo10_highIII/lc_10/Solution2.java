package com.lyx.lagouLearning.domo10_highIII.lc_10;

/**
 * @author lvyunxiao
 * @classname Solution2
 * @description Solution2
 * @date 2020/4/9
 * ref：https://leetcode-cn.com/problems/regular-expression-matching
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class Solution2 {


    public boolean isMatch(String s, String p) {
        // 分别用 m 和 n 表示 s 字符串和 p 字符串的长度
        int m = s.length(), n = p.length();

        // 定义一个二维布尔矩阵 dp
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 当两个字符串的长度都为 0，也就是空字符串的时候，它们互相匹配
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // p 的当前字符不是 '*'，判断当前的两个字符是否相等，如果相等，就看 dp[i-1][j-1] 的值，因为它保存了前一个匹配的结果
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && isMatch(s.charAt(i - 1), p.charAt(j - 1));
                } else {
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && isMatch(s.charAt(i - 1), p.charAt(j - 2));
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch(char a, char b) {
        return a == b || b == '.';
    }


}
