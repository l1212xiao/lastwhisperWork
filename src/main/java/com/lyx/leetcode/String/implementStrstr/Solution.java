package com.lyx.leetcode.String.implementStrstr;

/**
 * @Classname Solution
 * @Description Solution
 * @Date 2019/9/2
 * @auther lvyunxiao
 * https://leetcode-cn.com/problems/implement-strstr/solution/java-zi-fu-chuan-pi-pei-bi-jiao-jian-dan-de-fang-f/
 */
public class Solution {
    public int strStr(String haystack, String needle) {
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
}
