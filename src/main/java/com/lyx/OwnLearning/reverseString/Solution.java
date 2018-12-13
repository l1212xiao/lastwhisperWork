package com.lyx.OwnLearning.reverseString;

/**
 * Created by lyx on 2018/7/12.
 */
public class Solution {
    public static void main(String[] args) {

        String str = "the sky is blue";
        System.out.println(reverseStr(str));

    }

    public static String reverseStr(String s) {

        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
