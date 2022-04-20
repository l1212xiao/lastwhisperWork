package com.lyx.everyDayTraining.notOnlyMicro.productOfArrayExceptSelf;

/*
238. 除自身以外数组的乘积

给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请不要使用除法，且在 O(n) 时间复杂度内完成此题。

示例 1:

输入: nums = [1,2,3,4]
输出: [24,12,8,6]

示例 2:

输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]

提示：
    2 <= nums.length <= 10^5
    -30 <= nums[i] <= 30
    保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内

进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

 */


/**
 * @author lvyunxiao
 * @date 2022/4/14
 * @description
 */
public class Solution {

    // 暴力算法，超时
    public int[] productExceptSelfViolence(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                cur *= nums[j];
            }
            ans[i] = cur;
        }
        return ans;
    }

    // 预计算，计算左右乘积列表
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        int[] ans = new int[n];
        int[] leftPro = new int[n];
        int[] rightPro = new int[n];
        leftPro[0] = 1;
        rightPro[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            leftPro[i] = leftPro[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightPro[i] = rightPro[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = leftPro[i] * rightPro[i];
        }
        return ans;
    }



    // 方法二：空间复杂度 O(1) 的方法
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }
        int[] ans = new int[n];

        // ans[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 ans[0] = 1
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        // right 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 right = 1
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 ans[i]，右边的乘积为 right
            ans[i] = ans[i] * right;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 right 上
            right *= nums[i];
        }
        return ans;
    }

}
