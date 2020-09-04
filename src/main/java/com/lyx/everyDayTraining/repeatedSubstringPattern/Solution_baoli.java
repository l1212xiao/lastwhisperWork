package com.lyx.everyDayTraining.repeatedSubstringPattern;

/**
 * @author lvyunxiao
 * @date 2020/8/24
 * <p>
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 */
public class Solution_baoli {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
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
        Solution_baoli solution = new Solution_baoli();
        boolean b = solution.repeatedSubstringPattern(s);
        System.out.println(b);
    }
}
