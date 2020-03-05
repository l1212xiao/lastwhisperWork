package com.lyx.lagouLearning.demo03_sort;

import static com.lyx.lagouLearning.demo03_sort.Swap.swap;

/**
 * @author lvyunxiao
 * @classname BubbleSort
 * @description BubbleSort
 * @date 2019/12/24
 * <p>
 * 冒泡排序（Bubble Sort）
 * 基本思想
 * 给定一个数组，我们把数组里的元素通通倒入到水池中，这些元素将通过相互之间的比较，按照大小顺序一个一个地像气泡一样浮出水面。
 * <p>
 * 实现
 * 每一轮，从杂乱无章的数组头部开始，每两个元素比较大小并进行交换，直到这一轮当中最大或最小的元素被放置在数组的尾部，然后不断地重复这个过程，直到所有元素都排好位置。其中，核心操作就是元素相互比较。
 */
public class BubbleSort {

    public void sort(int[] nums) {
        //定义一个布尔变量 hasChange，用来标记每轮遍历中是否发生了交换
        boolean hasChange = true;

        //每轮遍历开始，将 hasChange 设置为 false
        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            hasChange = false;

            //进行两两比较，如果发现当前的数比下一个数还大，那么就交换这两个数，同时记录一下有交换发生
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    hasChange = true;
                }
            }
        }
    }

}
