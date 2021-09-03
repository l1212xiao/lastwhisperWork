package com.lyx.geek.AlgoMei.dynamicProgramming;

/*
5. 最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
示例 3：

输入：s = "a"
输出："a"
示例 4：

输入：s = "ac"
输出："a"
 */


/**
 * @author lvyunxiao
 * @date 2021/8/11
 * @description
 */
public class LongestPalindromicSubstring {

    /*
    [LC.5] 最长回文子串
     */
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示s[i..j]是回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] array = s.toCharArray();

        // 按照子串长度来枚举
        for (int l = 2; l <= len; l++) {
            // 枚举左边界
            for (int i = 0; i < len; i++) {
                // 左边界和子串长度可以确定右边界
                int j = i + l - 1;
                if (j >= len) {
                    break;
                }
                if (array[i] != array[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && l > maxLen) {
                    begin = i;
                    maxLen = l;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        // String str = "babad";
        String str = "bb";
        String longestPalindrome = s.longestPalindrome(str);
        System.out.println(longestPalindrome);
    }
}
