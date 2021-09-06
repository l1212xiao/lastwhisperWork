package com.lyx.everyDayTraining.WhenInMT.addStrings;

/*
415. 字符串相加

给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

提示：
    num1 和num2 的长度都小于 5100
    num1 和num2 都只包含数字 0-9
    num1 和num2 都不包含任何前导零
    你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */


/**
 * @author lvyunxiao
 * @date 2021/9/3
 * @description
 */
public class Solution {

    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 != len2) {
            if (len1 < len2) {
                return addStrings(num2, num1);
            } else {
                int diff = len1 - len2;
                for (int i = 0; i < diff; i++) {
                    num2 = '0' + num2;
                }
            }
        }

        String res = "";
        int n = num1.length();
        int pow = 0;
        for (int i = n - 1; i >= 0; i--) {
            int c1 = num1.charAt(i) - '0';
            int c2 = num2.charAt(i) - '0';
            res = (c1 + c2 + pow) % 10 + res;
            pow = (c1 + c2 + pow) / 10;
        }

        if (pow > 0) {
            res = '1' + res;
        }
        return res;
    }

    /*
    [LC.415]. 字符串相加
     */
    public String addStringsOrg(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, pow = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || pow != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + pow;
            ans.append(result % 10);
            pow = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String num1 = "12";
        // String num2 = "39";
        // String num1 = "1567";
        // String num2 = "89";
        String num1 = "9";
        String num2 = "99";
        String addStrings = s.addStrings(num1, num2);
        System.out.println(addStrings);
    }

}
