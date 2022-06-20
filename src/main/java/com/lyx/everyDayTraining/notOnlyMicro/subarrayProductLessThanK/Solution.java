package com.lyx.everyDayTraining.notOnlyMicro.subarrayProductLessThanK;

/*
713. 乘积小于 K 的子数组
给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。

示例 1：

输入：nums = [10,5,2,6], k = 100
输出：8
解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。

示例 2：

输入：nums = [1,2,3], k = 0
输出：0

提示:
    1 <= nums.length <= 3 * 104
    1 <= nums[i] <= 1000
    0 <= k <= 10^6
 */


/**
 * @author lvyunxiao
 * @date 2022/5/5
 * @description
 */
public class Solution {

    /* 乘积太大溢出
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int[] product = new int[n];

        product[0] = nums[0];
        for (int i = 1; i < n; i++) {
            product[i] = product[i - 1] * nums[i];
        }

        int count = 0;
        // i表示长度
        for (int i = 1; i <= n; i++) {
            // j表示开始点
            for (int j = 0; j <= n - i; j++) {
                if (getProduct(product, j, j + i - 1) < k) {
                    System.out.println("i:" + j + ",j:" + j + ",pro:" + getProduct(product, j, j + i - 1));
                    count++;
                }
            }
        }
        return count;
    }

    private int getProduct(int[] product, int start, int end) {
        if (start == 0) {
            return product[end];
        } else {
            return product[end] / product[start - 1];
        }
    }
     */


    // 方法二：滑动窗口 枚举右端点
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // int[] nums = {10, 5, 2, 6};
        // int k = 100;
        int[] nums = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;
        int numSubarrayProductLessThanK = s.numSubarrayProductLessThanK(nums, k);
        System.out.println(numSubarrayProductLessThanK);
    }

}
