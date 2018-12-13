package com.lyx.String.maxSubstring;

/**
 * Created by lyx on 2018/4/17.
 */
public class MaxSubstring {

    public String maxSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return null;
        }
        if (s1.equals("") || s2.equals("")) {
            return "";
        }

        String maxString = "";
        String minString = "";
        String curString = "";
        //s1.length() > s2.length() ? maxString = s1 : maxString = s2;
        if (s1.length() > s2.length()) {
            maxString = s1;
            minString = s2;
        } else {
            maxString = s2;
            minString = s1;
        }

        for (int i = 0; i < minString.length(); i++) {
            for (int start = 0, end = minString.length() - i; end <= minString.length(); start++, end++) {
                curString = minString.substring(start, end);
                if (maxString.contains(curString)) {
                    return curString;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String strOne = "abcdefg";
        String strTwo = "adefgwgeweg";
        MaxSubstring mx = new MaxSubstring();
        String ms = mx.maxSubstring(strOne, strTwo);
        System.out.println(ms);


    }
}
