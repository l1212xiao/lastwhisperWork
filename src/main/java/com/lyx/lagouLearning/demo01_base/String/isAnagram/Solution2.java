package com.lyx.lagouLearning.demo01_base.String.isAnagram;

/**
 * @author lvyunxiao
 * @classname Solution2
 * @description Solution2
 * @date 2019/11/30
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {

        final int length = t.length();
        if (s.length() != length) {
            return false;
        }

        String replaceFirst = s;
        for (int i = 0; i < length; i++) {
            final char tChar = t.charAt(i);
            replaceFirst = replaceFirst.replaceFirst(String.valueOf(tChar), "");
        }

        if ("".equals(replaceFirst)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String s = "ccc";
        String t = "car";

        final boolean anagram = solution.isAnagram(s, t);
        System.out.println(anagram);
    }
}
