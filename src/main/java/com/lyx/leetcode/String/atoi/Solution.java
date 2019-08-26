package com.lyx.leetcode.String.atoi;

/**
 * @Classname Solution
 * @Description Solution
 * @Date 2019/8/20
 * @auther lvyunxiao
 * <p>
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Solution {
    public static int myAtoi(String str) {
        char[] seq = str.trim().toCharArray();
        if (seq.length == 0 || (seq[0] < '0' || seq[0] > '9') && seq[0] != '-' && seq[0] != '+') return 0;
        int flag = 1;
        int result = 0;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == '-' && i == 0) {
                flag = -1;
                continue;
            }
            if (seq[i] == '+' && i == 0) continue;
            if (seq[i] < '0' || seq[i] > '9') break;
            if (result * flag > Integer.MAX_VALUE / 10 || (result * flag == Integer.MAX_VALUE / 10 && (seq[i] - '0') > Integer.MAX_VALUE % 10))
                return Integer.MAX_VALUE;
            if (result * flag < Integer.MIN_VALUE / 10 || (result * flag == Integer.MIN_VALUE / 10 && (seq[i] - '0') * flag < Integer.MIN_VALUE % 10))
                return Integer.MIN_VALUE;

            // core
            result = result * 10 + seq[i] - '0';
        }
        return result * flag;
    }

}
