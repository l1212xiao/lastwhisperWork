package com.lyx.everyDayTraining.WhenInMT.longestPalindromicSubsequence;

/**
 * @author lvyunxiao
 * @date 2021/12/30
 * @description
 */
public class Solution {

    public int getLongestPalindromeSubseq(String s) {
        int n = s.length();
        if (0 == n) {
            return 0;
        }

        // dp[i][j] 表示字符串从下标i开始，以下标j结尾的子串，最长回文子序列的长度
        int[][] dp = new int[n][n];

        // 初始化状态
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "bbbab";
        int longestPalindromeSubseq = s.getLongestPalindromeSubseq(str);
        System.out.println(longestPalindromeSubseq);
    }
}
