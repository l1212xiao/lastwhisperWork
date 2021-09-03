package com.lyx.geek.AlgoMei.dynamicProgramming;

/*
1143. 最长公共子序列
给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
    例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。

两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。


示例 1：

输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace" ，它的长度为 3 。

示例 2：

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc" ，它的长度为 3 。

示例 3：

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0 。

 */


/**
 * @author lvyunxiao
 * @date 2021/8/13
 * @description
 */
public class LongestCommonSubsequence {

    /*
    [LC.1143]. 最长公共子序列长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        if (l1 == 0 || l2 == 0) {
            return 0;
        }

        // dp[i][j]表示，text1[0:i]和text2[0:j]的最长公共子序列的长度
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1 + 1; i++) {
            for (int j = 0; j < l2 + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int up = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    int leftUp = dp[i - 1][j - 1];
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = leftUp + 1;
                    } else {
                        dp[i][j] = Math.max(left, up);
                    }
                }
            }
        }
        return dp[l1][l2];
    }

    /*
     得到最长公共子序列长度
     */
    public String getLongestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        if (l1 == 0 || l2 == 0) {
            return "";
        }

        // dp[i][j]表示，text1[0:i]和text2[0:j]的最长公共子序列的长度
        int[][] dp = new int[l1 + 1][l2 + 1];
        int[][] path = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1 + 1; i++) {
            for (int j = 0; j < l2 + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int up = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    int leftUp = dp[i - 1][j - 1];
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = leftUp + 1;
                    } else if (up >= left) {
                        dp[i][j] = up;
                        path[i][j] = 1;
                    } else {
                        dp[i][j] = left;
                        path[i][j] = -1;
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        getLCSByPath(path, text1, l1, l2, res);
        return res.reverse().toString();
    }

    public void getLCSByPath(int[][] path, String text1, int i, int j, StringBuilder res) {
        if (i == 0 || j == 0) {
            return;
        }
        if (path[i][j] == 0) {
            res.append(text1.charAt(i - 1));
            getLCSByPath(path, text1, i - 1, j - 1, res);
        } else if (path[i][j] == 1) {
            getLCSByPath(path, text1, i - 1, j, res);
        } else {
            getLCSByPath(path, text1, i, j - 1, res);
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence s = new LongestCommonSubsequence();
        // String text1 = "abcde", text2 = "ace";
        // String text1 = "bsbininm", text2 = "jmjkbkjkv";
        String text1 = "bsbinincm", text2 = "jmjkbkjkcv";
        // int longestCommonSubsequence = s.longestCommonSubsequence(text1, text2);
        // System.out.println(longestCommonSubsequence);
        String commonSubsequence = s.getLongestCommonSubsequence(text1, text2);
        System.out.println(commonSubsequence);
    }

}
