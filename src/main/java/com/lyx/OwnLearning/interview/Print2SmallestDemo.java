package com.lyx.OwnLearning.interview;

/**
 * @author lvyunxiao
 * @date 2020/8/11
 * <p>
 * 查找数组中第二小的元素
 */
public class Print2SmallestDemo {

    public static void print2Smallest(int[] arr) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < first) {
                second = first;
                first = arr[i];
            } else if (arr[i] < second && arr[i] != first) {
                second = arr[i];
            }
        }
        if (second == Integer.MAX_VALUE) {
            System.out.println("There is no second smallest element");
        } else {
            System.out.println("The smallest element is " + first
                    + " and second Smallest element is " + second);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 13, 1, 10, 34, 1};
        print2Smallest(arr);
    }

}
