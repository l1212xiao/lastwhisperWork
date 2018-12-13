package com.lyx.String.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyx on 2018/5/11.
 * 3
 * 解析：
 * 利用hashmap存储不重复子串，key为字符，
 * value为此字符的位置。从前向后进行遍历，
 * 只要map 中没有当前字符，便将其加入map 。并将子串长度加一。
 * 若当前字符已经出现在map 中，获得map中 此字符的位置，清除此位置以及之前的的所有key 。
 * 从此位置之后重新计算子串，保证了子串的不重复
 */
public class Solution {
    public int lengthOfLongentSubString(String s) {
        if (s == null) return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0, len = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                len++;
                map.put(s.charAt(i), i);
                maxLen = maxLen > len ? maxLen : len;
            } else {
                int index = map.get(s.charAt(i));
                for (int j = start; j <= index; j++) {
                    map.remove(s.charAt(j));
                }
                map.put(s.charAt(i), i);
                start = index + 1;
                len = i - index;
            }
        }
        return maxLen;
    }
}
