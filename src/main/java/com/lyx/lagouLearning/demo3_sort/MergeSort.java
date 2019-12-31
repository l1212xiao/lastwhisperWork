package com.lyx.lagouLearning.demo3_sort;

/**
 * @author lvyunxiao
 * @classname MergeSort
 * @description MergeSort
 * @date 2019/12/25
 * <p>
 * 归并排序（Merge Sort）
 * 基本思想
 * 核心是分治，就是把一个复杂的问题分成两个或多个相同或相似的子问题，然后把子问题分成更小的子问题，直到子问题可以简单的直接求解，最原问题的解就是子问题解的合并。归并排序将分治的思想体现得淋漓尽致。
 * <p>
 * 实现
 * 一开始先把数组从中间划分成两个子数组，一直递归地把子数组划分成更小的子数组，直到子数组里面只有一个元素，才开始排序。
 * <p>
 * 排序的方法就是按照大小顺序合并两个元素，接着依次按照递归的返回顺序，不断地合并排好序的子数组，直到最后把整个数组的顺序排好。
 */
public class MergeSort {
    public void sort(int[] nums, int low, int high) {
        // 判断是否只剩下最后一个元素
        if (low >= high) {
            return;
        }

        // 从中间将数组分成两个部分
        int mid = low + (high - low) / 2;

        // 分别递归地将左右两半排好序
        sort(nums, low, mid);
        sort(nums, mid + 1, high);

        // 将排好序的左右两半合并
        merge(nums, low, mid, high);
    }

    public void merge(int[] nums, int low, int mid, int high) {
        // 复制一份原来的数组
        int[] copy = nums.clone();

        // 定义一个 k 指针表示从什么位置开始修改原来的数组，i 指针表示左半边的起始位置，j 表示右半边的起始位置
        int k = low, i = low, j = mid + 1;

        // 其中，While 语句比较，一共可能会出现四种情况。
        // 左半边的数都处理完毕，只剩下右半边的数，只需要将右半边的数逐个拷贝过去。
        // 右半边的数都处理完毕，只剩下左半边的数，只需要将左半边的数逐个拷贝过去就好。
        // 右边的数小于左边的数，将右边的数拷贝到合适的位置，j 指针往前移动一位。
        // 左边的数小于右边的数，将左边的数拷贝到合适的位置，i 指针往前移动一位。
        while (k <= high) {
            if (i > mid) {
                nums[k++] = copy[j++];
            } else if (j > high) {
                nums[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
                nums[k++] = copy[j++];
            } else {
                nums[k++] = copy[i++];
            }
        }
    }
}
