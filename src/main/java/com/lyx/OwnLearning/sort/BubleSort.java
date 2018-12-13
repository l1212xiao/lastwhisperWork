package com.lyx.OwnLearning.sort;

/**
 * Created by lyx on 2018/5/21.
 */
public class BubleSort {
    public static void bubleSort(int[] arr) {
        boolean isSwapped = true;
        while (isSwapped) {
            isSwapped = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        isSwapped = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 2};
        bubleSort(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
