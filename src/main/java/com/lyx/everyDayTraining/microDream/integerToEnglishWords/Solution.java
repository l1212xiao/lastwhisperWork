package com.lyx.everyDayTraining.microDream.integerToEnglishWords;

/*
273. 整数转换英文表示

将非负整数 num 转换为其对应的英文表示。

示例 1：

输入：num = 123
输出："One Hundred Twenty Three"

示例 2：

输入：num = 12345
输出："Twelve Thousand Three Hundred Forty Five"

示例 3：

输入：num = 1234567
输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

提示：
    0 <= num <= 2^31 - 1
 */


import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyunxiao
 * @date 2022/3/7
 * @description
 */
public class Solution {

    static Map<Integer, String> numMap = new HashMap<>();

    static {
        numMap.put(0, "Zero");
        numMap.put(1, "One");
        numMap.put(2, "Two");
        numMap.put(3, "Three");
        numMap.put(4, "Four");
        numMap.put(5, "Five");
        numMap.put(6, "Six");
        numMap.put(7, "Seven");
        numMap.put(8, "Eight");
        numMap.put(9, "Nine");

        numMap.put(10, "Ten");
        numMap.put(11, "Eleven");
        numMap.put(12, "Twelve");
        numMap.put(13, "Thirteen");
        numMap.put(14, "Fourteen");
        numMap.put(15, "Fifteen");
        numMap.put(16, "Sixteen");
        numMap.put(17, "Seventeen");
        numMap.put(18, "Eighteen");
        numMap.put(19, "Nineteen");

        numMap.put(20, "Twenty");
        numMap.put(30, "Thirty");
        numMap.put(40, "Forty");
        numMap.put(50, "Fifty");
        numMap.put(60, "Sixty");
        numMap.put(70, "Seventy");
        numMap.put(80, "Eighty");
        numMap.put(90, "Ninety");
    }

    public String numberToWords(int num) {

        if (numMap.containsKey(num)) {
            return numMap.get(num);
        }
        if (num >= 1_000_000_000) {
            int m = num % 1_000_000_000;
            int n = num / 1_000_000_000;
            if (m == 0) {
                return numberToWords(n) + " Billion";
            }
            return numberToWords(n) + " Billion " + numberToWords(m);
        }
        if (num >= 1_000_000) {
            int m = num % 1_000_000;
            int n = num / 1_000_000;
            if (m == 0) {
                return numberToWords(n) + " Million";
            }
            return numberToWords(n) + " Million " + numberToWords(m);
        }
        if (num >= 1_000) {
            int m = num % 1_000;
            int n = num / 1_000;
            if (m == 0) {
                return numberToWords(n) + " Thousand";
            }
            return numberToWords(n) + " Thousand " + numberToWords(m);
        }
        if (num >= 100) {
            int m = num % 100;
            int n = num / 100;
            if (m == 0) {
                return numberToWords(n) + " Hundred";
            }
            return numMap.get(n) + " Hundred " + numberToWords(m);
        }
        if (num >= 20) {
            int m = num % 10;
            int n = num / 10;
            if (m == 0) {
                return numMap.get(n * 10);
            }
            return numMap.get(n * 10) + " " + numberToWords(m);
        }
        return numMap.get(num);
    }


    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords2(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num -= curNum * unit;
                StringBuffer curr = new StringBuffer();
                recursion(curr, curNum);
                curr.append(thousands[i]).append(" ");
                sb.append(curr);
            }
        }
        return sb.toString().trim();
    }

    public void recursion(StringBuffer curr, int num) {
        if (num == 0) {
            return;
        } else if (num < 10) {
            curr.append(singles[num]).append(" ");
        } else if (num < 20) {
            curr.append(teens[num - 10]).append(" ");
        } else if (num < 100) {
            curr.append(tens[num / 10]).append(" ");
            recursion(curr, num % 10);
        } else {
            curr.append(singles[num / 100]).append(" Hundred ");
            recursion(curr, num % 100);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // int num = 123;
        // int num = 12345;
        // int num = 1234567;
        // int num = 30;
        int num = 100;
        String numberToWords = s.numberToWords(num);
        System.out.println(numberToWords);
    }
}
