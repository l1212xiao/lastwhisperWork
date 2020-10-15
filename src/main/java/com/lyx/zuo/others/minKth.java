package com.lyx.zuo.others;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2020/9/16
 */
public class minKth {

    public static int minKth(int[] array, int k) {
        int[] arr = array.clone();
        return minKth(arr, 0, arr.length - 1, k - 1);
    }

    private static int minKth(int[] arr, int l, int r, int index) {
        if (l == r) {
            return arr[l];
        }
        int pivot = arr[l + (int) (Math.random() * (r - l + 1))];
        int[] range = partition(arr, l, r, pivot);
        if (index >= range[0] && index <= range[1]) {
            return arr[index];
        } else if (index < range[0]) {
            return minKth(arr, l, range[0] - 1, index);
        } else {
            return minKth(arr, range[1] + 1, r, index);
        }
    }

    public static int[] partition(int[] arr, int l, int r, int pivot) {
        int less = l - 1;
        int more = r + 1;
        int cur = l;
        while (cur < more) {
            if (arr[cur] < pivot) {
                swap(arr, cur++, ++less);
            } else if (arr[cur] > pivot) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 6, 2, 8, 9, 10, 3, 5};
        int[] indexs = partition(arr, 0, arr.length - 1, 5);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(indexs));
        System.out.println(minKth(arr, 3));

    }
}
