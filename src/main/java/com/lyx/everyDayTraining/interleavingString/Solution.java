package com.lyx.everyDayTraining.interleavingString;

/*
97. 交错字符串
给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
示例 1：

输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出：true
示例 2：

输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出：false
 */

/**
 * @author lvyunxiao
 * @date 2020/9/24
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        int n1 = chars1.length;
        int n2 = chars2.length;
        int n3 = chars3.length;
        if (n1 + n2 != n3) {
            return false;
        }
        // dp[i][j]表示 s1拿前i个字符，s2拿前j个字符，能否组成s3拿i+j个字符
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) {
            if (chars1[i - 1] == chars3[i - 1]) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= n2; i++) {
            if (chars2[i - 1] == chars3[i - 1]) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = (chars3[i + j - 1] == chars1[i - 1] && dp[i - 1][j]
                        ||
                        (chars3[i + j - 1] == chars2[j - 1] && dp[i][j - 1]));
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean interleave = s.isInterleave(s1, s2, s3);
        System.out.println(interleave);
    }
}
