package com.lyx.leetcode.Numbers.SearchInsertPosition;

/**
 * Created by lyx on 2018/7/12.
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {1, 3, 5, 6};
        int target = 2;
        System.out.println(solution.searchInsert(arr, target));
    }
}
