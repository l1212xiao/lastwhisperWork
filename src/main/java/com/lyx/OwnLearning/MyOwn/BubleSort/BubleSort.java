package com.lyx.OwnLearning.MyOwn.BubleSort;

/**
 * Created by lyx on 2018/5/15.
 */
public class BubleSort {
    public void bubleSort(int arr[]) {

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


}
