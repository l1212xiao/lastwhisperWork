package com.lyx.leetcode.Array.reverseBits;

/**
 * Created by lyx on 2018/8/7.
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            if((n & 1) == 1){
                ans ++;
            }
            n >>= 1;
        }
        return ans;
    }
}