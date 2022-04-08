package com.lyx.everyDayTraining.notOnlyMicro.selfDividingNumbers;

/*
728. 自除数

自除数 是指可以被它包含的每一位数整除的数。
    例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
自除数 不允许包含 0 。
给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。

示例 1：

输入：left = 1, right = 22
输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

示例 2:

输入：left = 47, right = 85
输出：[48,55,66,77]

提示：
    1 <= left <= right <= 10^4
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/3/31
 * @description
 */
public class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isSelfDividingNumber(int num) {
        int cur = num;
        while (cur != 0) {
            int mod = cur % 10;
            if (mod == 0 || num % mod != 0) {
                return false;
            }
            cur /= 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers2(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        out:
        for (int i = left; i <= right; i++) {
            int cur = i;
            while (cur != 0) {
                int t = cur % 10;
                if (t == 0 || i % t != 0) {
                    continue out;
                }
                cur /= 10;
            }
            ans.add(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int left = 1;
        int right = 22;
        List<Integer> dividingNumbers = s.selfDividingNumbers(left, right);
        System.out.println(Arrays.toString(dividingNumbers.toArray()));
    }
}
