package com.lyx.OwnLearning.wangyi;

import java.util.Scanner;

/**
 * Created by lyx on 2018/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, k = 0;
        while (sc.hasNext()) {
            n = sc.nextInt();
            k = sc.nextInt();
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minUnstable = getMax(arr)[0] - getMin(arr)[0];


    }

    public static int[] getMax(int[] arr) {
        //最大值，角标
        int[] max = new int[2];
        max[0] = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max[0]) {
                max[0] = arr[i];
                max[1] = i;
            }
        }
        return max;
    }

    public static int[] getMin(int[] arr) {
        //最小值，角标
        int[] min = new int[2];
        min[0] = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min[0]) {
                min[0] = arr[i];
                min[1] = i;
            }
        }
        return min;
    }


}
