package com.lyx.lagouLearning.demo08_highFreq.lc_03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/18
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * ref:https://kaiwu.lagou.com/course/courseInfo.htm?courseId=3#/detail/pc?id=36
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        // 定义一个哈希集合 set，初始化结果 max 为 0
        Set<Character> set = new HashSet<>();
        int max = 0;
        // 用快慢指针 i 和 j 扫描一遍字符串，如果快指针所指向的字符已经出现在哈希集合里，
        // 不断地尝试将慢指针所指向的字符从哈希集合里删除
        for (int i = 0, j = 0; j < s.length(); j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            // 当快指针的字符加入到哈希集合后，更新一下结果 max
            set.add(s.charAt(j));
            max = Math.max(max, set.size());
        }
        return max;
    }

    public int lengthOfLongestSubstringAnother(String s) {
        int slow = 0, fast = 0, maxLen = 0;
        Set<Character> set = new HashSet<Character>();

        while (fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast++));
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(slow++));
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstrings(String s) {
        // 定义一个哈希表用来记录上一次某个字符出现的位置，并初始化结果 max 为 0
        HashMap<Character, Integer> map = new HashMap();
        int max = 0;
        // 用快慢指针 i 和 j 扫描一遍字符串，若快指针所对应的字符已经出现过，则慢指针跳跃
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

}
