package com.lyx.MyOwn.targetMax;

/**
 * Created by lyx on 2018/9/26
 * <p>
 * 给定整数序列求最大连续字串和
 * <p>
 * 问题描述：
 * 给定无序正数序列，求连续字串最大和，例如：{-23,17,-7,11,-2,1,-34}，字串为{17,-7,11,}，最大和为21
 */
public class TargetMax {
    public static int getTargetMax(int[] arr) {
        int maxSum = arr[0];
        int curSum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (curSum <= 0) {
                curSum = arr[i];
            } else {
                curSum += arr[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-23, 17, -7, 11, -2, 1, -34};
        int targetMax = getTargetMax(arr);
        System.out.println(targetMax);
    }

}
