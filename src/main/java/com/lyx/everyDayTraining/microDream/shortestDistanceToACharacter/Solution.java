package com.lyx.everyDayTraining.microDream.shortestDistanceToACharacter;

/*
821. 字符的最短距离

给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。

示例 1：

输入：s = "loveleetcode", c = "e"
输出：[3,2,1,0,1,0,0,1,2,2,1,0]
解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。

示例 2：

输入：s = "aaab", c = "b"
输出：[3,2,1,0]

提示：
    1 <= s.length <= 104
    s[i] 和 c 均为小写英文字母
    题目数据保证 c 在 s 中至少出现一次
 */


import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2022/4/19
 * @description
 */
public class Solution {

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        // left[i]到其左侧最近的字符 c 的距离
        int[] left = new int[n];
        left[0] = s.charAt(0) == c ? 0 : n;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == c) {
                left[i] = 0;
            } else {
                left[i] = left[i - 1] + 1;
            }
        }

        // right[i]到其右侧最近的字符 c 的距离
        int[] right = new int[n];
        right[n - 1] = s.charAt(n - 1) == c ? 0 : n;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == c) {
                right[i] = 0;
            } else {
                right[i] = right[i + 1] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(left[i], right[i]);
        }
        return ans;
    }


    // 空间复杂度优化
    public int[] shortestToChar2(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        // left 最近的c来着左边的时候，left的下标
        int left = s.charAt(0) == c ? 0 : n;
        ans[0] = left;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == c) {
                left = i;
            }
            ans[i] = Math.abs(i - left);
        }

        // right 表示位置i 最近的c来着右边的时候，right的下标
        int right = s.charAt(n - 1) == c ? n - 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == c) {
                right = i;
            }
            ans[i] = Math.min(ans[i], Math.abs(right - i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "loveleetcode";
        char c = 'e';
        int[] char2 = s.shortestToChar2(str, c);
        System.out.println(Arrays.toString(char2));
    }


}
