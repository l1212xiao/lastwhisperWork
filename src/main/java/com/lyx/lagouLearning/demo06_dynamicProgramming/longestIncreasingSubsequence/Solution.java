package com.lyx.lagouLearning.demo06_dynamicProgramming.longestIncreasingSubsequence;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/2/24
 * <p>
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode/
 * 方法一：暴力法
 * 算法：
 * 最简单的方法是找到所有增加的子序列，然后返回最长增加的子序列的最大长度。为了做到这一点，我们使用递归函数 \text length of lislengthoflis
 * 返回从当前元素（对应于 curposcurpos）开始可能的 lis 长度（包括当前元素）。在每个函数调用中，我们考虑两种情况：
 * <p>
 * 当前元素大于包含在 lis 中的前一个元素。在这种情况下，我们可以在 lis 中包含当前元素。因此，我们通过将其包含在内，得出了 lis 的长度。此外，我们还通过不在 lis 中包含当前元素来找出 lis 的长度。因此，当前函数调用返回的值是两个长度中的最大值。
 * 当前元素小于包含在 lis 中的前一个元素。在这种情况下，我们不能在 lis 中包含当前元素。因此，我们只通过不在 lis 中包含当前元素（由当前函数调用返回）来确定 lis 的长度。
 * 时间复杂度：O(2^n),递归树的大小将为 2^n2
 * 空间复杂度：O(n^2),使用大小为 n*n 的 memo 数组。
 *
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = solution.lengthOfLIS(nums);
        System.out.println(i);
    }

}
