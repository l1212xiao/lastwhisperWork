package com.lyx.leetcode.Numbers.FactorialTrailingZeroes;

/**
 * Created by lyx on 2018/5/28.
 * 172. Factorial Trailing Zeroes
 */
public class Solution {
    public int trailingZeroes(int n) {
        int fac = getFac(n);
        String str = Integer.toString(fac);
        int count = 0;
        for ( int i = str.length()-1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static int getFac(int x) {
        if (x <= 0) return -1;
        int nums[] = new int[x];
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] * (i + 1);
        }
        return nums[x - 1];
    }

    public static void main(String[] args) {
        System.out.println(getFac(13));
    }

}
