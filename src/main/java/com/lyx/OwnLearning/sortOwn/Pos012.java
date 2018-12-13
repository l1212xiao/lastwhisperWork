package com.lyx.OwnLearning.sortOwn;

/**
 * Created by lyx on 2018/8/23.
 * 一个数组中只有0,1,2三个元素，进行排序，要求时间复杂度为O(n)
 * <p>
 * 思路：
 * 设置三个标记指针，pos0，pos2，cur
 * 令pos0从前往后遍历，指向第一个非0的位置，pos2从后往前遍历，指向第一个非2的位置
 * 然后cur从pos0开始往后遍历：
 * 遇到0就和pos0交换，pos0++;
 * 遇到1什么也不做;
 * 遇到2就和pos2交换，pos2向前滑动到下一个非2的位置，交换后还要重新检查cur的值；
 * 直到cur与pos2相遇。
 * 一次遍历，复杂度是O(n)，因为每次操作都使得数组更为有序，不像快排需要重复比较，所以比应用快排的方法效率高一些。
 */
public class Pos012 {
    public static void sort(int[] nums) {

        int pos0 = 0, pos2 = nums.length - 1, cur = 0;

        while (nums[pos0] == 0) {
            pos0++;
        }
        while (nums[pos2] == 2) {
            pos2--;
        }
        cur = pos0;

        while (cur <= pos2) {
            if (nums[cur] == 0) {
                swap(nums, cur, pos0);
                pos0++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, pos2);
                if (nums[cur] == 0) {
                    swap(nums, cur, pos0);
                    pos0++;
                }
                pos2--;
                while (nums[pos2] == 2) {
                    pos2--;
                }
            }
            cur++;

        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 1, 2, 0, 2, 0, 1, 2, 2, 2, 1, 2};
        sort(nums);
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }

}
