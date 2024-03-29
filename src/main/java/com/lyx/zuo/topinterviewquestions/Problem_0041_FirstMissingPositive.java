package com.lyx.zuo.topinterviewquestions;

public class Problem_0041_FirstMissingPositive {
    public static int firstMissingPositive(int[] arr) {
		int l = 0;
		int r = arr.length;
		while (l < r) {
			if (arr[l] == l + 1) {
				l++;
			} else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
				swap(arr,l,--r);
			} else {
				swap(arr, l, arr[l] - 1);
			}
		}
		return l + 1;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
