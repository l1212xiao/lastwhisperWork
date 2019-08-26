package com.lyx.leetcode.String.zigzagConversion;

/**
 * @Classname Solution
 * @Description Solution
 * @Date 2019/8/20
 * @auther lvyunxiao
 * <p>
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 */
public class Solution {
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int getTime = 1;
            int pos = i;
            while (pos < s.length()) {
                sb.append(chars[pos]);
                pos = pos + getDiff(numRows, i, getTime);
                getTime++;
            }
        }
        return sb.toString();
    }

    public static int getDiff(int numRows, int n, int getTime) {
        if (n == 0 || n == numRows - 1) {
            return (numRows - 1) * 2;
        }
        if (getTime % 2 != 0) {
            return (numRows - 1 - n) * 2;
        } else {
            return 2 * n;
        }
    }

    public static void main(String[] args) {
        String s = convert("LEETCODEISHIRING", 4);
        System.out.println(s);
    }
}
