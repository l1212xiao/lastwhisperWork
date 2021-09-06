package com.lyx.everyDayTraining.WhenInMT.multiplyStrings;

/*
43. 字符串相乘

给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"

示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"

说明：
    num1 和 num2 的长度小于110。
    num1 和 num2 只包含数字 0-9。
    num1 和 num2 均不以零开头，除非是数字 0 本身。
    不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */


/**
 * @author lvyunxiao
 * @date 2021/9/3
 * @description
 */
public class Solution {

    /*
    [LC.43]. 字符串相乘
    */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res = "0";
        String add = "";
        int len = num2.length();
        for (int i = len - 1; i >= 0; i--) {
            char c = num2.charAt(i);
            String part = multiply(num1, c) + add;
            res = addStrings(res, part);
            add += '0';
        }
        return res;
    }

    public String multiply(String num, char c) {
        if ("0".equals(num) || '0' == c) {
            return "0";
        }
        int i = num.length() - 1;
        int pow = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || pow != 0) {
            int x = i >= 0 ? num.charAt(i) - '0' : 0;
            int y = c - '0';
            int result = x * y + pow;
            ans.append(result % 10);
            pow = result / 10;
            i--;
        }
        return ans.reverse().toString();
    }

    public String addStrings(String num1, String num2) {
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
        String num1 = "123", num2 = "456";
        String multiply = s.multiply(num1, num2);
        System.out.println(multiply);

    }

}
