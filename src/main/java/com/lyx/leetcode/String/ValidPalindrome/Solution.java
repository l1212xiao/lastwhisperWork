package com.lyx.leetcode.String.ValidPalindrome;

/**
 * Created by lyx on 2018/5/10.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s =="") {
            return true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = s.toLowerCase().toCharArray();
        for (int i = 0; i <chars.length; i++) {
            if ((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >='0' && chars[i] <= '9')) {
                stringBuffer.append(chars[i]);
            }
        }

        char[] newChars = stringBuffer.toString().toCharArray();
        for (int i = 0; i < newChars.length/2; i++) {
            if (newChars[i] != newChars[newChars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
