package com.lyx.everyDayTraining.beforeMeituan.repeatNum;

import java.util.BitSet;

/**
 * @author lvyunxiao
 * @date 2020/8/31
 */
public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        int[] nums = {1, 2, 3, 4, 5, 6, 1};
        for (int num : nums) {
            if (bitSet.get(num)) {
                System.out.println(num);
                break;
            } else {
                bitSet.set(num);
            }
        }
    }
}
