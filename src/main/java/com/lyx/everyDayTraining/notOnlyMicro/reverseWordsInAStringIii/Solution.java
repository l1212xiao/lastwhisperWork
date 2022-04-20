package com.lyx.everyDayTraining.notOnlyMicro.reverseWordsInAStringIii;

/*
557. 反转字符串中的单词 III
给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1：

输入：s = "Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

示例 2:

输入： s = "God Ding"
输出："doG gniD"

提示：
    1 <= s.length <= 5 * 10^4
    s 包含可打印的 ASCII 字符。
    s 不包含任何开头或结尾空格。
    s 里 至少 有一个词。
    s 中的所有单词都用一个空格隔开。
 */


/**
 * @author lvyunxiao
 * @date 2022/4/8
 * @description
 */
public class Solution {

    public String reverseWords(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int start = 0, end = 0;
        while (end < n) {
            while (end < n && arr[end] != ' ') {
                end++;
            }
            for (int i = start, j = end - 1; i < j; i++, j--) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            end++;
            start = end;
        }
        String ans = new String(arr);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "Let's take LeetCode contest";
        String reverseWords = s.reverseWords(str);
        System.out.println(reverseWords);
    }
}
