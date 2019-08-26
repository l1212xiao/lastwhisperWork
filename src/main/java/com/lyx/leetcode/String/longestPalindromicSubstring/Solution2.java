package com.lyx.leetcode.String.longestPalindromicSubstring;

/**
 * @Classname Solution2
 * @Description Solution2
 * @Date 2019/8/16
 * @auther lvyunxiao
 */
public class Solution2 {

    public String longestPalindrome(String s) {
        int max = 0;
        String result = "";
        // 暴力破解
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                if (isPalindrome(subStr) && subStr.length() > max) {
                    result = subStr;
                    max = subStr.length();
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 改进暴力法，使用动态规划判断回文数
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int length = s.length();
        Boolean[][] dp = new Boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) {//遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
                dp[start][end] = (len == 1 || len == 2 || dp[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
//                if (len == 1) {
//                    dp[start][end] = true;
//                } else if (len == 2 && s.charAt(0) == s.charAt(1)) {
//                    dp[start][end] = true;
//                } else if (dp[start + 1][end - 1] && s.charAt(start) == s.charAt(end)) {
//                    dp[start][end] = true;
//                } else {
//                    dp[start][end] = false;
//                }
//
//                System.out.println();
//                System.out.println("substring is " + s.substring(start, end + 1));
//                System.out.println("dp-" + start + "," + end + " is " + dp[start][end]);

                if (dp[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        }
        return maxPal;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String baba = solution2.longestPalindrome2("baba");
        System.out.println(baba);

    }
}
