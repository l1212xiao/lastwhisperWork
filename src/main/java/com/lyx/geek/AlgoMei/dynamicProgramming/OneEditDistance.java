package com.lyx.geek.AlgoMei.dynamicProgramming;

/*
161. 相隔为 1 的编辑距离
给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
注意：

满足编辑距离等于 1 有三种可能的情形：
    往 s 中插入一个字符得到 t
    从 s 中删除一个字符得到 t
    在 s 中替换一个字符得到 t

示例 1：

输入: s = "ab", t = "acb"
输出: true
解释: 可以将 'c' 插入字符串 s 来得到 t。

示例 2:

输入: s = "cab", t = "ad"
输出: false
解释: 无法通过 1 步操作使 s 变为 t。

示例 3:

输入: s = "1203", t = "1213"
输出: true
解释: 可以将字符串 s 中的 '0' 替换为 '1' 来得到 t。
 */


/**
 * @author lvyunxiao
 * @date 2021/8/12
 * @description
 */
public class OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == 0) {
            return t.length() == 1;
        }
        if (t.length() == 0) {
            return s.length() == 1;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            int editDis = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    editDis++;
                }
                if (editDis > 1) {
                    return false;
                }
            }
            return editDis == 1;
        } else {
            if (s.length() > t.length()) {
                String tempStr = s;
                s = t;
                t = tempStr;
            }
            int editDis = 0;

            int i = 0, j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j)) {
                    editDis++;
                    j++;
                } else {
                    i++;
                    j++;
                }
                if (editDis > 1) {
                    return false;
                }
            }
            while (j != t.length()) {
                j++;
                editDis++;
            }
            return editDis == 1;
        }
    }

    // 官方解答
    // 链接：https://leetcode-cn.com/problems/one-edit-distance/solution/xiang-ge-wei-1-de-bian-ji-ju-chi-by-leetcode/
    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            int ns = s.length();
            int nt = t.length();

            // Ensure that s is shorter than t.
            if (ns > nt)
                return isOneEditDistance(t, s);

            // The strings are NOT one edit away distance
            // if the length diff is more than 1.
            if (nt - ns > 1)
                return false;

            for (int i = 0; i < ns; i++)
                if (s.charAt(i) != t.charAt(i))
                    // if strings have the same length
                    if (ns == nt)
                        return s.substring(i + 1).equals(t.substring(i + 1));
                        // if strings have different lengths
                    else
                        return s.substring(i).equals(t.substring(i + 1));

            // If there is no diffs on ns distance
            // the strings are one edit away only if
            // t has one more character.
            return (ns + 1 == nt);
        }
    }

    /*
    面试题 01.05. 一次编辑
    字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。

    示例 1:

    输入:
    first = "pale"
    second = "ple"
    输出: True

    示例 2:

    输入:
    first = "pales"
    second = "pal"
    输出: False

     */
    public boolean oneEditAway(String first, String second) {
        int l1 = first.length();
        int l2 = second.length();
        if (l1 > l2) {
            return oneEditAway(second, first);
        }
        if (l2 - l1 > 1) {
            return false;
        }
        for (int i = 0; i < l1; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (l1 == l2) {
                    return first.substring(i + 1).equals(second.substring(i + 1));
                } else {
                    return first.substring(i).equals(second.substring(i + 1));
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        OneEditDistance s = new OneEditDistance();
        String s1 = "a";
        String t1 = "ac";
        boolean oneEditDistance = s.isOneEditDistance(s1, t1);
        System.out.println(oneEditDistance);
    }

}
