package com.lyx.everyDayTraining.beforeMeituan.predictTheWinner;

/**
 * @author lvyunxiao
 * @date 2020/9/1
 * <p>
 * 486. 预测赢家
 * <p>
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 */
public class Solution {

    public boolean PredictTheWinner1(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        return f(nums, 0, nums.length - 1) >= s(nums, 0, nums.length - 1);
    }

    public int f(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        return Math.max(nums[l] + s(nums, l + 1, r), nums[r] + s(nums, l, r - 1));
    }

    public int s(int[] nums, int l, int r) {
        if (l == r) return 0;
        return Math.min(f(nums, l + 1, r), f(nums, l, r - 1));
    }

    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int n = nums.length;
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];

        for (int i = 0; i < n; i++) {
            f[i][i] = nums[i];
        }

        for (int i = 1; i < n; i++) {
            int l = 0;
            int r = i;
            while (l < n && r < n) {
                f[l][r] = Math.max(nums[l] + s[l + 1][r], nums[r] + s[l][r - 1]);
                s[l][r] = Math.min(f[l + 1][r], f[l][r - 1]);
                l++;
                r++;
            }
        }
        return f[0][n - 1] >= s[0][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 5, 2};
        boolean b = solution.PredictTheWinner(nums);
        System.out.println(b);
    }
}
