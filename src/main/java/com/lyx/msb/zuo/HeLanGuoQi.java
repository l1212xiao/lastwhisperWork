package com.lyx.msb.zuo;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2020/8/26
 * <p>
 * 荷兰国旗问题（Java）
 * 需求：
 * 给一个数组arr，给一个数num，将数组中小于num的数放在左边，
 * 等于num的数放在中间，大于num的数全部放在右边。
 */
public class HeLanGuoQi {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 6, 2, 8, 9, 10, 3, 5};
        int[] indexs = partition(arr, 0, arr.length - 1, 5);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(indexs));

    }

    public static int[] partition(int[] arr, int l, int r, int num) {
        int less = l - 1;
        int more = r + 1;

        while (l < more) {
            if (arr[l] < num) {
                swap(arr, l++, ++less);
            } else if (arr[l] > num) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
