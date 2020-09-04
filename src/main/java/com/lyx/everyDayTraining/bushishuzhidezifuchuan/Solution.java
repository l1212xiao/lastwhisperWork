package com.lyx.everyDayTraining.bushishuzhidezifuchuan;

import java.util.regex.Pattern;

/**
 * @author lvyunxiao
 * @date 2020/9/2
 * <p>
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 */
public class Solution {
    public boolean isNumber(String s) {
        // 整数
        String regex1 = "[+|-]?[0-9]+";
        // 小数
        String regex2 = "([+|-]?[0-9]+[.][0-9]*)|([+|-]?[0-9]*[.][0-9]+)|([.][0-9]+)";
        // 带e表示的
        String regex3 = "([+|-]?[0-9]+[.]?[0-9]*[e|E][+|-]?[0-9]+)|([+|-]?[.][0-9]+[e|E][+|-]?[0-9]+)";
        return Pattern.matches(regex1, s.trim())
                || Pattern.matches(regex2, s.trim())
                || Pattern.matches(regex3, s.trim());
    }

    public boolean isNumber2(String s) {
        return Pattern.matches("([+|-]?[0-9]+)" +
                        "|(([+|-]?[0-9]+[.][0-9]*)|([+|-]?[0-9]*[.][0-9]+)|([.][0-9]+))" +
                        "|(([+|-]?[0-9]+[.]?[0-9]*[e|E][+|-]?[0-9]+)|([+|-]?[.][0-9]+[e|E][+|-]?[0-9]+))"
                , s.trim());
    }

    public boolean isNumber3(String s) {
        if (s.endsWith("f") || s.endsWith("D")) return false;
        try {
            Double.valueOf(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // String s1 = "+100";
        // System.out.println(solution.isNumber(s1));
        //
        // String s2 = "5e2";
        // System.out.println(solution.isNumber(s2));
        //
        // String s3 = "-123";
        // System.out.println(solution.isNumber(s3));
        //
        // String s4 = "+100";
        // System.out.println(solution.isNumber(s4));
        //
        // String s5 = "3.1416";
        // System.out.println(solution.isNumber(s5));
        //
        // String s6 = "-1E-16";
        // System.out.println(solution.isNumber(s6));
        //
        // String s7 = "0123";
        // System.out.println(solution.isNumber(s7));
        //
        // System.out.println("=====================");
        //
        // String s21 = "12e";
        // System.out.println(solution.isNumber(s21));
        //
        // String s22 = "1a3.14";
        // System.out.println(solution.isNumber(s22));
        //
        // String s23 = "1.2.3";
        // System.out.println(solution.isNumber(s23));
        //
        // String s24 = "+-5";
        // System.out.println(solution.isNumber(s24));
        //
        // String s25 = "12e+5.4";
        // System.out.println(solution.isNumber(s25));

        System.out.println("=====================");
        // String s31 = ".2e81";
        // String s31 = "e9"; //false
        // String s31 = ".e1"; //false
        // String s31 = "-.3e6"; //true
        String s31 = "1.431352e7"; //true
        System.out.println(solution.isNumber(s31));

        System.out.println("=====================");

        String regex1 = "[+|-]?[0-9]+";
        String regex2 = "([+|-]?[0-9]+[.][0-9]*)|([+|-]?[0-9]*[.][0-9]+)|([.][0-9]+)";
        String regex3 = "[+|-]?[0-9]+[e|E][+|-]?[0-9]+";

        System.out.println(Pattern.matches(regex1, s31.trim()));
        System.out.println(Pattern.matches(regex2, s31.trim()));
        System.out.println(Pattern.matches(regex3, s31.trim()));
    }
}
