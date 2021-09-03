package com.lyx.geek.AlgoMei.string;

/*
159. 至多包含两个不同字符的最长子串
给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。

示例 1:

输入: "eceba"
输出: 3
解释: t 是 "ece"，长度为3。

示例 2:

输入: "ccaabbb"
输出: 5
解释: t 是 "aabbb"，长度为5。
 */


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyunxiao
 * @date 2021/8/17
 * @description
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    /*
    [LC.159]. 至多包含两个不同字符的最长子串
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) {
            return n;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLen = 2;

        while (right < n) {
            // 如果 hashmap 包含小于 3 个不同字符，那么将当前字符 s[right] 放到 hashmap 中并将右指针往右移动一次。
            if (map.size() < 3) {
                map.put(s.charAt(right), right);
                right++;
            }
            // 如果 hashmap 包含 3 个不同字符，将最左边的字符从 哈希表中删去，并移动左指针，
            // 以便滑动窗口只包含 2 个不同的字符。
            if (map.size() == 3) {
                int delIndex = Collections.min(map.values());
                map.remove(s.charAt(delIndex));
                left = delIndex + 1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abaccc";
        LongestSubstringWithAtMostTwoDistinctCharacters s = new LongestSubstringWithAtMostTwoDistinctCharacters();
        int lengthOfLongestSubstringTwoDistinct = s.lengthOfLongestSubstringTwoDistinct(str);
        System.out.println(lengthOfLongestSubstringTwoDistinct);

    }
}
