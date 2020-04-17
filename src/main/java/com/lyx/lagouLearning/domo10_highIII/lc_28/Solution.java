package com.lyx.lagouLearning.domo10_highIII.lc_28;


/**
 * @author lvyunxiao
 * @classname solution
 * @description solution
 * @date 2020/4/13
 * <p>
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * ref：https://leetcode-cn.com/problems/implement-strstr
 * https://kaiwu.lagou.com/course/courseInfo.htm?courseId=3#/detail/pc?id=86
 */
public class Solution {

    // 解题思路一：滑动窗口算法
    public int strStr1(String haystack, String needle) {
        int needleLen = needle.length();
        int haystackLen = haystack.length();
        if (haystackLen < needleLen) {
            return -1;
        }
        int start = 0, end = needleLen - 1;
        while (end < haystackLen) {
            if (haystack.substring(start, end + 1).equals(needle)) {
                return start;
            }
            start++;
            end++;
        }
        return -1;
    }

    // 解题思路二：KMPKMP（Knuth-Morris-Pratt）是由三人联合发表的一个算法，
    // 目的就是为了在一个字符串haystack中找出另外一个字符串needle出现的所有位置。它的核心思想是避免暴力法当中出现的不必要的比较。
    // 为了说明这两个问题，必须先讲解 KMP 里的一个重要数据结构——最长的公共前缀和后缀，英文是 Longest Prefix and Suffix，简称 LPS。
    // LPS 其实是一个数组，记录了字符串从头开始到某个位置结束的一段字符串当中，公共前缀和后缀的最大长度。
    // 所谓公共前缀和后缀，就是说字符串的前缀等于后缀，并且，前缀和后缀不能是同一段字符串。

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n == 0) {
            return 0;
        }

        int[] lps = getLPS(needle);
        int i = 0, j = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return i - n;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    public int[] getLPS(String str) {
        // 初始化一个 lps 数组用来保存最终的结果
        int[] lps = new int[str.length()];
        // lps 的第一个值一定是 0，即长度为 1 的字符串的最长公共前缀后缀的长度为 0，
        // 直接从第二个位置遍历。并且，初始化当前最长的 lps 长度为 0，用 len 变量记录下
        int i = 1, len = 0;

        // 指针 i 遍历整个输入字符串
        while (i < str.length()) {
            // 若 i 指针能延续前缀和后缀，则更新 lps 值为 len+1
            if (str.charAt(i) == str.charAt(len)) {
                lps[i++] = ++len;
            }
            // 否则，判断 len 是否大于 0，尝试第二长的前缀和后缀，是否能继续延续下去/
            else if (len > 0) {
                len = lps[len - 1];
            }
            // 所有的前缀和后缀都不符合，则当前的 lps 为 0，i++
            else {
                i++;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //"mississippi"
        // "issip"
        String haystack = "mississippi", needle = "issip";
        System.out.println(solution.strStr(haystack, needle));
    }
}
