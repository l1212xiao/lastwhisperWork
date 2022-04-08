package com.lyx.everyDayTraining.notOnlyMicro.zigzagConversion;

/*
6. Z 字形变换

将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);

示例 1：

输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"

示例 2：

输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I

示例 3：

输入：s = "A", numRows = 1
输出："A"

提示：
    1 <= s.length <= 1000
    s 由英文字母（小写和大写）、',' 和 '.' 组成
    1 <= numRows <= 1000
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/3/31
 * @description
 */
public class Solution {

    public String convert(String s, int numRows) {
        List<List<Character>> path = new ArrayList<>();
        int n = s.length();
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            path.add(new ArrayList<>());
        }
        int direction = 1;
        int row = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            path.get(row).add(c);
            if (row + direction < 0 || row + direction >= numRows) {
                direction = -direction;
            }
            row = row + direction;
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> characters : path) {
            for (Character character : characters) {
                sb.append(character);
            }
        }
        return sb.toString();
    }

    // 利用二维矩阵模拟
    public String convert2(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        // 周期
        int t = r * 2 - 2;
        // 每个周期所占用的列
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; i++) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                x++; // 向下移动
            } else {
                x--;
                y--; // 向右上移动
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "PAYPALISHIRING";
        // int numRows = 3;
        int numRows = 4;
        String convert = s.convert(str, numRows);
        System.out.println(convert);
    }
}
