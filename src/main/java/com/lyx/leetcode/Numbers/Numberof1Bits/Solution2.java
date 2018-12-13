package com.lyx.Numbers.Numberof1Bits;

/**
 * Created by lyx on 2018/6/13.
 */
public class Solution2 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n >>>= 1;
        }
        return result;
    }
}
