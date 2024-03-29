package com.lyx.everyDayTraining.WhenInMT.addDigits;

/*
258. 各位相加

给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。

示例 1:

输入: num = 38
输出: 2
解释: 各位相加的过程为：
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
由于 2 是一位数，所以返回 2。

示例 1:

输入: num = 0
输出: 0

提示：
    0 <= num <= 2^31 - 1

进阶：你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？

 */


/**
 * @author lvyunxiao
 * @date 2022/3/3
 * @description
 */
public class Solution {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int ans = 0;
        while (num != 0) {
            ans += (num % 10);
            num /= 10;
        }
        return addDigits(ans);
    }

    public int addDigits2(int num) {
        while (num > 9) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    /*
    数学
     */
    public int addDigits3(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 38;
        int digits = s.addDigits(num);
        System.out.println(digits);
    }
}
