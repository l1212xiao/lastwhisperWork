package com.lyx.leetcode.Array.medianOfTwoSortedArrays;

/**
 * @Classname Solution2
 * @Description Solution2
 * @Date 2019/7/27
 * @auther lvyunxiao
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = combineAndSort(nums1, nums2);
        int length = result.length;
        if (length == 1) {
            return result[0] * 1.0;
        }
        double x = result[length / 2 - 1] * 1.0;
        double y = result[length / 2] * 1.0;
        if (length % 2 == 0) {
            return (x + y) / 2;
        } else {
            return y;
        }
    }

    public int[] combineAndSort(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            result[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            result[k++] = nums2[j++];
        }
        return result;
    }
}
