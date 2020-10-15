package com.lyx.OwnLearning.others.BinaryTransform;

/**
 * Created by lyx on 2018/8/15.
 */
public class HammingWeight {
    public static int hammingWeight(int n) {
        return (int) Integer.toBinaryString(n).chars().filter(c -> '1' == c).count();
    }

    public static int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = hammingWeight2(10);
        System.out.println(i);

    }
}
