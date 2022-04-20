package com.lyx.everyDayTraining.notOnlyMicro.countNumbersWithUniqueDigits;

/*
357. 统计各位数字都不同的数字个数
给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10^n 。

示例 1：

输入：n = 2
输出：91
解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。

示例 2：

输入：n = 0
输出：1

提示：
    0 <= n <= 8
 */


/**
 * @author lvyunxiao
 * @date 2022/4/11
 * @description
 */
public class Solution {
    /*
    方法一：排列组合

思路

首先考虑两种边界情况：

    当 n=0 时，0≤x<1，x 只有 1 种选择，即 0。
    当 n=1 时，100≤x<10，x 有 10 种选择，即 0∼9。

    当 n=2 时，0≤x<100，x 的选择可以由两部分构成：只有一位数的 x 和有两位数的 x。只有一位数的 x 可以由上述的边界情况计算。
    有两位数的 x 可以由组合数学进行计算：第一位的选择有 9 种，即 1∼9，第二位的选择也有 9 种，即 0∼9 中除去第一位的选择。

    更一般地，含有 d （2≤d≤10）位数的各位数字都不同的数字 x 的个数可以由公式 9 × A9 (上)d−1 (下)9  计算。再加上含有小于
    d 位数的各位数字都不同的数字 x 的个数，即可得到答案。

     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }

}
