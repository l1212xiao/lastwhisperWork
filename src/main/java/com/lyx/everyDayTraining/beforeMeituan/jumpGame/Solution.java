package com.lyx.everyDayTraining.beforeMeituan.jumpGame;

/*
55. 跳跃游戏
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */


/**
 * @author lvyunxiao
 * @date 2020/9/22
 */
public class Solution {
    // public boolean canJump(int[] nums) {
    //     return canJump(nums, 0);
    // }
    //
    // public boolean canJump(int[] nums, int index) {
    //     if (index + nums[index] >= nums.length - 1) {
    //         return true;
    //     }
    //     for (int i = index + 1; i <= index + nums[index]; i++) {
    //         if (canJump(nums, i)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // 作者：LeetCode-Solution
    // 链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Solution s = new Solution();

        // int[] nums = {3, 2, 1, 0, 4};
        // int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {1, 2, 3};
        boolean canJump = s.canJump(nums);
        System.out.println(canJump);

    }
}
