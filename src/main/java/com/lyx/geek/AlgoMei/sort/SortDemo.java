package com.lyx.geek.AlgoMei.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2021/7/9
 * @description
 */
public class SortDemo {

    public static void main(String[] args) {
        SortDemo s = new SortDemo();
        int[] arr = new int[]{3, 1, 2, 5, 4};
        // System.out.println("before: " + Arrays.toString(arr));
        // s.bubbleSort(arr);
        // System.out.println("after:  " + Arrays.toString(arr));

        // System.out.println("before: " + Arrays.toString(arr));
        // s.insertSort(arr);
        // System.out.println("after:  " + Arrays.toString(arr));

        // System.out.println("before: " + Arrays.toString(arr));
        // s.selectSort(arr);
        // System.out.println("after:  " + Arrays.toString(arr));

        // System.out.println("before: " + Arrays.toString(arr));
        // s.mergeSort(arr, 0, arr.length - 1);
        // System.out.println("after:  " + Arrays.toString(arr));

        // List<Integer> list = new ArrayList<>();
        // list.add(3);
        // list.add(1);
        // list.add(2);
        // Collections.sort(list);
        // Arrays.sort(arr);
        System.out.println("before: " + Arrays.toString(arr));
        s.shellSort(arr);
        System.out.println("after:  " + Arrays.toString(arr));


    }

    public void bubbleSort(int[] a) {
        int n = a.length;
        if (n < 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean hasChanged = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    hasChanged = true;
                }
            }
            if (!hasChanged) {
                break;
            }
        }
    }

    public void insertSort(int[] a) {
        int n = a.length;
        if (n < 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    public void selectSort(int[] a) {
        int n = a.length;
        if (n < 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] a, int low, int high) {
        // 判断是否只剩下最后一个元素
        if (low >= high) {
            return;
        }

        // 从中间将数组分成两个部分
        int mid = low + (high - low) / 2;

        // 分别递归地将左右两半排好序
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);

        // 将排好序的左右两半合并
        merge(a, low, mid, high);
    }

    public void merge(int[] a, int low, int mid, int high) {
        // 复制一份原来的数组
        int[] copy = a.clone();

        // 定义一个 k 指针表示从什么位置开始修改原来的数组，i 指针表示左半边的起始位置，j 表示右半边的起始位置
        int k = low, i = low, j = mid + 1;

        // 其中，While 语句比较，一共可能会出现四种情况。
        // 左半边的数都处理完毕，只剩下右半边的数，只需要将右半边的数逐个拷贝过去。
        // 右半边的数都处理完毕，只剩下左半边的数，只需要将左半边的数逐个拷贝过去就好。
        // 右边的数小于左边的数，将右边的数拷贝到合适的位置，j 指针往前移动一位。
        // 左边的数小于右边的数，将左边的数拷贝到合适的位置，i 指针往前移动一位。
        while (k <= high) {
            if (i > mid) {
                a[k++] = copy[j++];
            } else if (j > high) {
                a[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
                a[k++] = copy[j++];
            } else {
                a[k++] = copy[i++];
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (arr == null) {
            return;
        }
        if (start < end) {
            int mid = partition(arr, start, end);
            quickSort(arr, start, mid - 1);
            quickSort(arr, mid + 1, end);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (start < end && pivot < arr[end]) {
                end--;
            }
            swap(arr, start, end);
            while (start < end && pivot > arr[start]) {
                start++;
            }
            swap(arr, start, end);
        }
        return start;
    }


    // 希尔排序
    // 希尔排序(Shell’s Sort)是插入排序的一种，是直接插入排序算法的一种更高版本的改进版本。
    //
    // 把记录按步长gap分组，对每组记录采用直接插入排序方法进行排序；
    // 随着步长逐渐减小，所分成的组包含的记录越来越多；
    // 当步长值减小到1时，整个数据合成一组，构成一组有序记录，完成排序；
    public void shellSort(int[] a) {
        int n = a.length;
        if (n < 1) {
            return;
        }
        // step:步长
        for (int step = n / 2; step > 0; step /= 2) {
            // 对一个步长区间进行比较[step, n)
            for (int i = step; i < n; i++) {
                int value = a[i];
                int j;

                // 对步长区间中具体的元素进行比较
                for (j = i - step; j >= 0 && a[j] > value; j -= step) {
                    // j为左区间的取值，j + step为右区间的对应值
                    a[j + step] = a[j];
                }
                // 此时step为一个负数，[j + step] 为左区间上的初始交换值
                a[j + step] = value;
            }
        }
    }


}
