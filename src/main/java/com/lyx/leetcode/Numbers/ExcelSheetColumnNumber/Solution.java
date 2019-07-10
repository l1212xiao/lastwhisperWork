package com.lyx.leetcode.Numbers.ExcelSheetColumnNumber;

/**
 * Created by lyx on 2018/5/28.
 * 171. Excel Sheet Column Number
 */
public class Solution {
    public int titleToNumber(String s) {
        int carry = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int numi = s.charAt(i) - 'A' + 1;
            int nump = (int) (numi * Math.pow(26, carry));
            num += nump;
            carry++;
        }
        return num;
    }
}
