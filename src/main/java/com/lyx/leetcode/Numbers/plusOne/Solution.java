package com.lyx.leetcode.Numbers.plusOne;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/1/19
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final int[] ints = solution.plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(ints));

    }
}
