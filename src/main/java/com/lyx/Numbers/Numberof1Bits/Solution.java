package com.lyx.Numbers.Numberof1Bits;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyx on 2018/6/13.
 * 191. Number of 1 Bits
 * wrong
 */
public class Solution {
    public int hammingWeight(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(0, n % 2);
            n /= 2;
        }
        for (int i = list.size(); i < 32; i++) {
            list.add(0, 0);
        }
        int count = 0;
        for (int x : list) {
            if (x == 1) {
                count++;
            }
        }
        return count;
    }
}
