package com.lyx.lagouLearning.demo03_sort;


import static com.lyx.lagouLearning.demo03_sort.Swap.swap;

/**
 * @author lvyunxiao
 * @classname QuickSort
 * @description QuickSort
 * @date 2019/12/25
 * <p>
 * 基本思想
 * <p>
 * 快速排序也采用了分治的思想。
 * <p>
 * 实现
 * <p>
 * 把原始的数组筛选成较小和较大的两个子数组，然后递归地排序两个子数组。
 */
public class QuickSort {
    public void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return; // 判断是否只剩下一个元素，是，则直接返回
        }

        // 利用 partition 函数找到一个随机的基准点
        int p = partition(nums, low, high);

        // 递归地对基准点左半边和右半边的数进行排序
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    public int partition(int[] nums, int low, int high) {
        // 随机选择一个数作为基准值，nums[hi] 就是基准值(一般使用low)
        // swap(nums, randRange(low, high), high);
        swap(nums, low, high);

        int i, j;

        // 从左到右用每个数和基准值比较，若比基准值小，则放到指针 i 所指向的位置。循环完毕后，i 指针之前的数都比基准值小
        for (i = low, j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, i++, j);
            }
        }

        // 末尾的基准值放置到指针 i 的位置，i 指针之后的数都比基准值大
        swap(nums, i, j);

        // 返回指针 i，作为基准点的位置
        return i;
    }
}
