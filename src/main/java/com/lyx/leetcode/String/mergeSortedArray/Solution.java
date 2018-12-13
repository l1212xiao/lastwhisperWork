package com.lyx.String.mergeSortedArray;

/**
 * Created by lyx on 2018/4/16.
 * 88. Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1, indexTotal = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[indexTotal--] = nums1[index1--];
            } else {
                nums1[indexTotal--] = nums2[index2--];
            }
        }
        if (index1 == -1) {
            while (index2 >= 0) {
                nums1[indexTotal--] = nums2[index2--];
            }
        }
    }
}
