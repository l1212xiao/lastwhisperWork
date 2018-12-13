package com.lyx.OwnLearning.BinaryTransform;

/**
 * Created by lyx on 2018/8/15.
 */
public class DecToBin {

    public static int decToBin(int num) {

        int sum = 0;
        int carry = 1;

        while (num != 0) {
            int remainder = num % 2;
            num /= 2;
            sum += remainder * carry;
            carry *= 10;
        }
        return sum;

    }

    public static void main(String[] args) {
        int i = decToBin(10);
        System.out.println(i);
        String string = Integer.toBinaryString(10);
        System.out.println(string);
    }
}
