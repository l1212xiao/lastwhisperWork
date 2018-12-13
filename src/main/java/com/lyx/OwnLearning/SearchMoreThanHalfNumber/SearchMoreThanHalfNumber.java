package com.lyx.OwnLearning.SearchMoreThanHalfNumber;

/**
 * Created by lyx on 2018/7/9.
 * 找出数组中出现次数超过一半的数
 */

/**
 * 现在有一个数组，已知一个数出现的次数超过了一半，
 * 请用O(n)的复杂度的算法找出这个数。
 * 分析：设数A出现次数超过一半。每次删除两个不同的数，
 * 在剩余的数中，数A出现的次数仍超过一半。
 * 通过重复这个过程，求出最后的结果。
 * 这个题目与编程之美中寻找水王相同
 */
public class SearchMoreThanHalfNumber {
    public static int search(int[] nums) {
        int count = 0;
        int current = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                current = nums[i];
                count = 1;
            } else {
                if (nums[i] == current)
                    count++;
                else
                    count--;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 1, 1, 1,};
        int i = search(nums);
        System.out.println(i);
    }

}
