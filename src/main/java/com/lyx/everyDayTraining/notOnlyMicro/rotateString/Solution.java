package com.lyx.everyDayTraining.notOnlyMicro.rotateString;

/*
796. 旋转字符串
给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
    例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。

示例 1:

输入: s = "abcde", goal = "cdeab"
输出: true

示例 2:

输入: s = "abcde", goal = "abced"
输出: false


提示:
    1 <= s.length, goal.length <= 100
    s 和 goal 由小写英文字母组成

 */


/**
 * @author lvyunxiao
 * @date 2022/4/7
 * @description
 */
public class Solution {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.length() <= 1) {
            return s.equals(goal);
        }
        if (s.equals(goal)) {
            return true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            s = s.substring(1) + s.charAt(0);
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    // 方法二：搜索子字符串,只需要检查 goal 是否为 s+s 的子字符串即可
    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String str = "abcde", goal = "cdeab";
        String str = "abcde", goal = "abced";
        boolean rotateString = s.rotateString(str, goal);
        System.out.println(rotateString);
    }
}
