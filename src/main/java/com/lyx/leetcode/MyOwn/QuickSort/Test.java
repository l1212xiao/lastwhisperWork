package com.lyx.leetcode.MyOwn.QuickSort;

import com.lyx.leetcode.MyOwn.BubleSort.BubleSort;

import java.util.Arrays;

/**
 * Created by lyx on 2018/5/15.
 */
public class Test {
    public static void main(String[] args) {
        //int arr[] = {9, 1, 5, 8, 3, 7, 4, 6, 2};
        int arr[] = {9, 1, 5, 8, 3, 7, 4, 6, 2};

        //quickSort(arr, 0, arr.length - 1);
        BubleSort bubleSort = new BubleSort();
        bubleSort.bubleSort(arr);
        //Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //int arrTest[] = {1, 2, 3};
        //swap(arrTest, 0, 1);
    }
}
