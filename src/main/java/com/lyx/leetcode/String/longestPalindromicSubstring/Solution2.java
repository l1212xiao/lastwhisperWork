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

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String baba = solution2.longestPalindrome("baba");
        System.out.println(baba);

    }
}
