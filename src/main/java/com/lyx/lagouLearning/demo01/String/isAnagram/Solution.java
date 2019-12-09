package com.lyx.lagouLearning.demo01.String.isAnagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/11/30
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> sCharMap = toCharMap(s);
        Map<Character, Integer> tCharMap = toCharMap(t);

        final int len = sCharMap.size();
        if (len != tCharMap.size()) {
            return false;
        }

        final Set<Map.Entry<Character, Integer>> entries = sCharMap.entrySet();
        for (final Map.Entry<Character, Integer> entry : entries) {
            if (!tCharMap.containsKey(entry.getKey()) || !tCharMap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public Map<Character, Integer> toCharMap(String str) {
        char[] sCharArray = str.toCharArray();
        Map<Character, Integer> sCharMap = new HashMap<>();
        for (char sChar : sCharArray) {
            if (sCharMap.containsKey(sChar)) {
                Integer sNum = sCharMap.get(sChar);
                sCharMap.put(sChar, sNum + 1);
            } else {
                sCharMap.put(sChar, 1);
            }
        }
        return sCharMap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "rat";
        String t = "car";

        final boolean anagram = solution.isAnagram(s, t);
        System.out.println(anagram);
    }

}
