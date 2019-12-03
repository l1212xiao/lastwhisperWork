package com.lyx.lagouLearning.demo01.isAnagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyunxiao
 * @classname Solution3
 * @description Solution3
 * @date 2019/11/30
 */
public class Solution3 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);

//        String letterStr = "abcdefghijklmnopqrstuvwxyz";
//        Map<Character, Integer> letterMap = new HashMap<>(26);
//        final int letterLength = letterStr.length();
//        for (int i = 0; i < letterLength; i++) {
//            letterMap.put(letterStr.charAt(i), 0);
//        }


//        Map<Character, Integer> letterMap = new HashMap<>();
//
//        final int length = s.length();
//        if (t.length() != length) {
//            return false;
//        }
//
//        for (int i = 0; i < length; i++) {
//            final char sChar = s.charAt(i);
//            final char tChar = t.charAt(i);
//
//            letterMap.put(sChar, letterMap.getOrDefault(sChar,0) + 1);
//            letterMap.put(tChar, letterMap.getOrDefault(tChar,0) - 1);
//        }
//
//        for (final Map.Entry<Character, Integer> entry : letterMap.entrySet()) {
//            if (entry.getValue() != 0) {
//                return false;
//            }
//        }
//        return true;


    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String s = "anagram";
        String t = "nagaram";

        final boolean anagram = solution.isAnagram(s, t);
        System.out.println(anagram);
    }

}
