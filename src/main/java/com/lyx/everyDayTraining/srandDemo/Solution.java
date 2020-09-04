package com.lyx.everyDayTraining.srandDemo;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2020/8/27
 * <p>
 * 1、数据里有{1,2,3,4,5,6,7,8,9}，请随机打乱顺序，生成一个新的数组（请以代码实现）
 */
public class Solution {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] srand(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            // 获取随机下标
            int temp = (int) (Math.random() * (a.length - i)); // 随机数[0，a.length -i)
            b[i] = a[temp];
            // 将此时a[temp]的下标移动到靠后位置
            // swap(a,temp,a.length-1);
            int change = a[a.length - i - 1];
            a[a.length - i - 1] = a[temp];
            a[temp] = change;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(srand(a)));
    }

}
