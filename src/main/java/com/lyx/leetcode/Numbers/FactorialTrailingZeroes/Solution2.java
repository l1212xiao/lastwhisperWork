package com.lyx.Numbers.FactorialTrailingZeroes;

/**
 * Created by lyx on 2018/5/28.
 * 172.Factorial Trailing Zeroes
 */
public class Solution2 {
    public int trailingZeroes(int n) {
        int count_5 = 0;
        while (n > 0) {
            count_5 += n / 5;
            n /= 5;
        }
        return count_5;
    }
}
