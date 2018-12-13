package cn.lyx.sort;

/**
 * Created by lyx on 2018/5/21.
 */
public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {
        if (arr == null) return;
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
        int pivote = arr[start];
        while (start < end) {
            while (start < end && pivote < arr[end]) {
                end--;
            }
            swap(arr, start, end);
            while (start < end && pivote > arr[start]) {
                start++;
            }
            swap(arr, start, end);
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2};
        quickSort(arr, 0, arr.length - 1);

        for (int x : arr) {
            System.out.print(x+" ");
        }
    }

}
