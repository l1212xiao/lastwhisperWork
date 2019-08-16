package com.lyx.leetcode.String.longestPalindromicSubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution
 * @Description Solution
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @Date 2019/7/27
 * @auther lvyunxiao
 */
public class Solution {

    public String longestPalindrome(String s) {
        int i = 0, j = 0, k = 0;
        int length = s.length();
        String result = "";
        List<Character> list = new ArrayList<>();
        while (i < length && j < length) {
            if (isPalindrome(listToString(list))) {
                list.add(s.charAt(j++));
                if (j - i > k) {
                    k = j - i;
                    result = listToString(list);
                }
            } else {
                list.remove(i++);
            }
        }
        return result;
    }

    public String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (final Character character : list) {
            sb.append(character);
        }
        return sb.toString();
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
        Solution solution = new Solution();
        boolean result = solution.isPalindrome("aba");
        System.out.println(result);

        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('a');

        String s = solution.listToString(list);
        System.out.println(s);

        System.out.println(solution.longestPalindrome("aba"));


    }
}
