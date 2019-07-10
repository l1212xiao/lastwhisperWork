package com.lyx.leetcode.Numbers.ExcelSheetColumnNumber;

/**
 * Created by lyx on 2018/5/28.
 */
public class Solution2 {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int carry = 0;
        int num = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int numi = chars[i] - 'A' + 1;
            int nump = (int) (numi * Math.pow(26, carry));
            num += nump;
            carry++;
        }
        return num;
    }
}
