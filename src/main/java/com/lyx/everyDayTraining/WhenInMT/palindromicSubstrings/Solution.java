package com.lyx.everyDayTraining.WhenInMT.palindromicSubstrings;

/*
647. 回文子串
给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

回文字符串 是正着读和倒过来读一样的字符串。
子字符串 是字符串中的由连续字符组成的一个序列。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

示例 1：

输入：s = "abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入：s = "aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"


提示：

1 <= s.length <= 1000
s 由小写英文字母组成
 */


/**
 * @author lvyunxiao
 * @date 2021/12/30
 * @description
 */
public class Solution {

    /*
    [LC.647]. 回文子串,统计并返回这个字符串中回文子串的数目
     */
    public int countSubstrings(String s) {
        // 判断初始状态
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();

        // 设置dp，dp[i][j]表示以下标i开始，以下标j结尾的子串，是回文子串
        boolean[][] dp = new boolean[n][n];

        // 定义结果
        int ans = 0;

        // 初始化状态
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        // 遍历
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]));
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
