package com.lyx.everyDayTraining.beforeMeituan.repeatedSubstringPattern;

/**
 * @author lvyunxiao
 * @date 2020/8/24
 */
public class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) return false;
        for (int i = 1; i <= s.length() / 2; i++) {
            String substring = s.substring(0, i);
            if (s.length() % i == 0) {
                if (isMatch(s, substring)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMatch(String s, String subString) {
        if (s.equals(subString)) {
            return false;
        }
        String subStringTemp = subString;
        while (subStringTemp.length() < s.length()) {
            subStringTemp += subString;
        }
        return s.equals(subStringTemp);
    }

    public static void main(String[] args) {
        String s = "aba";
        Solution2 solution = new Solution2();
        boolean b = solution.repeatedSubstringPattern(s);
        System.out.println(b);
    }
}
