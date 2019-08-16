package com.lyx.leetcode.Array.medianOfTwoSortedArrays;

import java.util.Arrays;

/**
 * @Classname Solution
 * @Description Solution
 * @Date 2019/7/27
 * @auther lvyunxiao
 */
public class Solution {
    public static double findMediaSortedArrays(int[] nums1, int[] nums2) {
        int[] combineAndSort = combineAndSort(nums1, nums2);
        int length = combineAndSort.length;
        if (length % 2 == 0) {
            int i = combineAndSort[length / 2 - 1];
            int j = combineAndSort[length / 2];

            return (i * 1.0 + j * 1.0) / 2;

            //return ((combineAndSort[length / 2 - 1] + combineAndSort[length / 2]) / 2);
        } else {
            return combineAndSort[length / 2];
        }
    }

    public static int[] combineAndSort(int[] nums1, int[] nums2) {
        int[] result = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int[] result = combineAndSort(nums1, nums2);

        double mediaSortedArrays = findMediaSortedArrays(nums1, nums2);

        for (final int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("media is :" + mediaSortedArrays);

    }
}
