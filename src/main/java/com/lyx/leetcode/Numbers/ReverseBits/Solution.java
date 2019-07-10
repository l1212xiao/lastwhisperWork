package com.lyx.leetcode.Numbers.ReverseBits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lyx on 2018/6/13.
 * 190. Reverse Bits
 * no ac when n==1
 */
public class Solution {
    public Long reverseBits(int n) {

        List<Integer> list = new ArrayList<>();

        while (n != 0) {
            list.add(0, n % 2);
            n /= 2;
        }

        for (int i = list.size(); i < 32; i++) {
            list.add(0, 0);
        }

        Collections.reverse(list);

        Long res = 0L;
        for (int i = 31; i >= 0; i--) {
            double carry = (Math.pow(2, i));
            res += (list.get(31 - i) * (long)carry);
        }
        return res;

    }
}
