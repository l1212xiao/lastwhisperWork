package com.lyx.everyDayTraining.longestCommonPrefix;

/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
 */


/**
 * @author lvyunxiao
 * @date 2020/10/13
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int n = strs[0].length();
        // for (int i = 1; i < strs.length; i++) {
        //     n = Math.min(n, strs[i].length());
        // }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"cir", "car"};
        String longestCommonPrefix = s.longestCommonPrefix(strs);
        System.out.println(longestCommonPrefix);
    }
}
