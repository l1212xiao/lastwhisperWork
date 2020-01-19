package com.lyx.lagouLearning.demo04_recursionAndBacktracking.decodeWays;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/1/3
 * <p>
 * LeetCode 第 91 题，解码的方法。
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 * <p>
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 解题思路
 * 就例题中的第二个例子，给定编码后的消息是字符串“226”，如果对其中“22”的解码有 m 种可能，那么，加多一个“6”在最后，相当于在最终解密出来的字符串里多了一个“F”字符而已，总体的解码还是只有 m 种。
 * 对于“6”而言，如果它的前面是”1”或者“2”，那么它就有可能是“16”，“26”，所以还可以再往前看一个字符，发现它是“26”。而前面的解码组合是 k 个，那么在这 k 个解出的编码里，添加一个“Z”，所以总的解码个数就是 m+k。
 */
public class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        char[] chars = s.toCharArray();
        return decode(chars, chars.length - 1);
    }

    // 字符串转换成字符数组，利用递归函数 decode，从最后一个字符向前递归
    private int decode(char[] chars, int index) {
        // 处理到了第一个字符,只能有一种解码方法，返回 1
        if (index <= 0) {
            return 1;
        }
        int count = 0;
        char cur = chars[index];
        char pre = chars[index - 1];

        // 当前字符比 “0” 大，则直接利用它之前的字符串所求得的结果
        if (cur > '0') {
            count = decode(chars, index - 1);
        }

        // 由前一个字符和当前字符所构成的数字，值必须要在 1 到 26 之间，否则无法进行解码
        if (pre == '1' || (pre == '2' && cur <= '6')) {
            count += decode(chars, index - 2);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final int i = solution.numDecodings("226");
        System.out.println(i);
    }

}
