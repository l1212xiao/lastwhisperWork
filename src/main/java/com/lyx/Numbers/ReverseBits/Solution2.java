package com.lyx.Numbers.ReverseBits;

/**
 * Created by lyx on 2018/6/13.
 */
public class Solution2 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }
}
