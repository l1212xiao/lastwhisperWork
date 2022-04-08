package com.lyx.everyDayTraining.notOnlyMicro.maxConsecutiveOnesIII;

/*
1004. 最大连续1的个数 III
给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。

示例 1：

输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
解释：[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。

示例 2：

输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。


提示：
    1 <= nums.length <= 10^5
    nums[i] 不是 0 就是 1
    0 <= k <= nums.length
 */


/**
 * @author lvyunxiao
 * @date 2022/3/29
 * @description
 */
public class Solution {

    public int longestOnes(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // zeroNums[i] 表示[0,i]上0的个数
        int[] zeroNums = new int[n];
        zeroNums[0] = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < n; i++) {
            zeroNums[i] = nums[i] == 0 ? zeroNums[i - 1] + 1 : zeroNums[i - 1];
        }
        // i 滑动窗口的长度 j 开始位置
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j <= n - i; j++) {
                int end = j + i - 1;
                int zeroNum = 0;
                if (j == 0) {
                    zeroNum = zeroNums[end];
                } else {
                    zeroNum = zeroNums[end] - zeroNums[j - 1];
                }
                if (zeroNum <= k) {
                    return i;
                }
            }
        }
        return k;
    }

    // 滑动窗口 + 二分查找
    public int longestOnes2(int[] nums, int k) {
        int n = nums.length;
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] + (1 - nums[i - 1]);
        }

        int ans = 0;
        for (int right = 0; right < n; right++) {
            int left = binarySearch(p, p[right + 1] - k);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int binarySearch(int[] p, int target) {
        int low = 0, high = p.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (p[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }



    // 滑动窗口
    // 当我们使用滑动窗口代替二分查找解决本题时，就不需要显式地计算并保存出前缀和数组了。
    // 我们只需要知道 left 和 right 作为下标在前缀和数组中对应的值，
    // 因此我们只需要用两个变量 lsum 和 rsum 记录 left 和 right 分别对应的前缀和即可。
    public int longestOnes3(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            rsum += 1 - nums[right];
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int longestOnes = s.longestOnes(nums, k);
        System.out.println(longestOnes);
    }


}
