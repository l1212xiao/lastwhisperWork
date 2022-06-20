package com.lyx.everyDayTraining.notOnlyMicro.submissions;

/*
396. 旋转函数

给定一个长度为 n 的整数数组 nums 。
假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
    F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
返回 F(0), F(1), ..., F(n-1)中的最大值 。
生成的测试用例让答案符合 32 位 整数。

示例 1:

输入: nums = [4,3,2,6]
输出: 26
解释:
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。

示例 2:

输入: nums = [100]
输出: 0

提示:
    n == nums.length
    1 <= n <= 105
    -100 <= nums[i] <= 100
 */


import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2022/4/22
 * @description
 */
public class Solution {

    /*
    模拟，超时
    public int maxRotateFunction(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, getFn(nums, i));
        }
        return max;
    }

    private int getFn(int[] nums, int m) {
        int n = nums.length;
        int sum = 0;
        int idx = 0;
        if (m != 0) {
            idx = n - m;
        }
        for (int i = 0; i < n; i++) {
            sum += i * nums[idx];
            if (idx + 1 == n) {
                idx = 0;
            } else {
                idx++;
            }
        }
        return sum;
    }
     */

    /*
     方法一：迭代
思路
记数组 nums 的元素之和为 numSum。根据公式，可以得到：
    F(0)= 0×nums[0] + 1×nums[1]+…+(n−1)×nums[n−1]
    F(1)= 1×nums[0] + 2×nums[1]+…+0×nums[n−1]=F(0)+numSum−n×nums[n−1]

更一般地，当 1≤k<n1时，
    F(k)= F(k−1) + numSum − n×nums[n−k]。我们可以不停迭代计算出不同的 F(k)F(k)F(k)，并求出最大值。

     */
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int numSum = Arrays.stream(nums).sum();
        int f = 0;
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int ans = f;
        for (int i = n - 1; i >= 1; i--) {
            f += numSum - n * nums[i];
            ans = Math.max(ans, f);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4, 3, 2, 6};
        int maxRotateFunction = s.maxRotateFunction(nums);
        System.out.println(maxRotateFunction);
    }
}
