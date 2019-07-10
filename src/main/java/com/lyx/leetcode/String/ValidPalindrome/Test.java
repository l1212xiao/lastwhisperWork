package com.lyx.leetcode.String.ValidPalindrome;

/**
 * Created by lyx on 2018/5/10.
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "0P";
        boolean isP = solution.isPalindrome(str);
        System.out.println(isP);
    }
}
