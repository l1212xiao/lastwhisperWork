package com.lyx.OwnLearning.MyOwn.QuickSort;

/**
 * Created by lyx on 2018/5/15.
 */
public class QuickSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int start, int end) {
        assert (arr != null);
        int pivote = arr[start];

        while (start < end) {
            while (pivote < arr[end] && start < end) {
                end--;
            }
            swap(arr, start, end);
            while (pivote > arr[start] && start < end) {
                start++;
            }
            swap(arr, start, end);
        }
        //System.out.println(Arrays.toString(arr) + " " + start);
        return start;
    }

    public static void quickSort(int arr[], int start, int end) {
        assert (arr != null);

        if (start < end) {
            int mid = partition(arr, start, end);
            quickSort(arr, start, mid - 1);
            quickSort(arr, mid + 1, end);
        }
    }

}
