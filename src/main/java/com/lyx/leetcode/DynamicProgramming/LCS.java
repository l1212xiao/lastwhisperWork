package com.lyx.leetcode.DynamicProgramming;

import java.util.Scanner;

/**
 * @Classname LCS
 * @Description LCS
 * @Date 2019/8/17
 * @auther lvyunxiao
 * <p>
 * 原文链接：https://blog.csdn.net/a515557595_xzb/article/details/88296989
 * (Longest Common Subsequence,LCS):在字符串A和字符串B中都出现的序列，且顺序与母串保持一致最长的那个序列。
 */
public class LCS {
    public static int getLCS(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    // 考虑i为0或j为0的情况
                    dp[i][j] = 0;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static String getLCStr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        Integer[][] dp = new Integer[m + 1][n + 1];
        int maxLen = 0;
        int pos = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0 || s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        pos = i;
                    }
                }
            }
        }
        return s1.substring(pos - maxLen, pos);
    }

    public static String longestPalindrome(String s) {
        String s1 = s;
        String s2 = new StringBuffer(s).reverse().toString();
        int length = s1.length();
        Integer[][] dp = new Integer[length + 1][length + 1];
        int maxLen = 0;
        int pos = 0;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
                if (i == 0 || j == 0 || s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    int beforeRev = length - j;
                    if (dp[i][j] > maxLen && beforeRev + dp[i][j] == i) {
                        maxLen = dp[i][j];
                        pos = i;
                    }
                }
            }
        }
        return s1.substring(pos - maxLen, pos);
    }

    public static void main(String[] args) {
        String lcStr = longestPalindrome("aacdefcaa");
        System.out.println(lcStr);
    }
}
