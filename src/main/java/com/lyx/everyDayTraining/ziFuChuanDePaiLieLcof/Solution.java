package com.lyx.everyDayTraining.ziFuChuanDePaiLieLcof;

/*
剑指 Offer 38. 字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

 */

import java.util.*;

public class Solution {
    public String[] permutation(String s) {
        Set<String> ans = new HashSet<>();
        dfs(s, ans, new ArrayList<>());
        return ans.toArray(new String[0]);
    }

    public void dfs(String s, Set<String> ans, List<Integer> used) {
        if (used.size() == s.length()) {
            StringBuilder path = new StringBuilder();
            for (int i : used) {
                path.append(s.charAt(i));
            }
            ans.add(path.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!used.contains(i)) {
                used.add(i);
                dfs(s, ans, used);
                used.remove(used.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] abcs = s.permutation("aab");
        System.out.println(Arrays.toString(abcs));
    }
}
