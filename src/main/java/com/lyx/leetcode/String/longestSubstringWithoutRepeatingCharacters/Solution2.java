package com.lyx.leetcode.String.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyx on 2018/5/11.
 * The idea is use a hash set to track the longest substring without repeating characters so far,
 * use a fast pointer j to see if character j is in the hash set or not,
 * if not, great, add it to the hash set, move j forward and update the max length,
 * otherwise, delete from the head by using a slow pointer i until we can put character j to the hash set.
 */
public class Solution2 {
    public int lengthOfLongestSubString(String s) {
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
}
