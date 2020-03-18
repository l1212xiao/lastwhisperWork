package com.lyx.lagouLearning.demo08_highFreq.findKthLargest;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/18
 * <p>
 * 快速选择算法
 * 快速选择算法，可以在O(n)的时间内从长度为n的没有排序的数组中取出第k大的数，运用了快速排序的思想。
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    // 随机取一个基准值,这里取第一个数作为基准值
    public int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;
        //比基准值小的数放左边,把比基准值大的数放右边
        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[high]) {
                swap(nums, pivot++, i);
            }
        }
        swap(nums, pivot, high);

        // 判断基准值的位置是不是第k大的元素
        int count = high - pivot + 1;
        // 如果是,就返回结果。
        if (count == k) {
            return nums[pivot];
        }
        // 如果发现基准值小了,继续往右边搜索
        if (count > k) {
            return quickSelect(nums, pivot + 1, high, k);
        }
        // 如果发现基准值大了,就往左边搜索
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 3, 1, 6, 8, 9, 7, 4};
        Solution s = new Solution();
        int kthLargest = s.findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }
}
