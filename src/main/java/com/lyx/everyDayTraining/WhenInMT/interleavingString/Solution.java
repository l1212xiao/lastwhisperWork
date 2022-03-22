package com.lyx.everyDayTraining.WhenInMT.interleavingString;


/*
97. 交错字符串
给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。

两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
提示：a + b 意味着字符串 a 和 b 连接。

示例 1：


输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出：true
示例 2：

输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出：false
示例 3：

输入：s1 = "", s2 = "", s3 = ""
输出：true

提示：

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1、s2、和 s3 都由小写英文字母组成
 */




/**
 * @author lvyunxiao
 * @date 2021/12/21
 * @description
 */
public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int l1 = s1.length();
        int l2 = s2.length();

        // dp[i][j] 表示s1前i个元素（s1[0,i)）和 s2前j个元素（s2[0,j)）可以拼接成s3前i+j个元素（s3[0,i+j)）
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int j = 1; j <= l2; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                } else if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        // String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        // String s1 = "a", s2 = "", s3 = "a";
        final boolean interleave = s.isInterleave(s1, s2, s3);
        System.out.println(interleave);

    }



}
