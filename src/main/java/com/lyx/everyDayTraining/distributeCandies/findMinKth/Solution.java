package com.lyx.everyDayTraining.distributeCandies.findMinKth;

import java.util.PriorityQueue;

/**
 * @author lvyunxiao
 * @date 2020/8/28
 */
public class Solution {
    public static int findMinKth(int[] arr, int k) {
        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // for (int i = 0; i < arr.length; i++) {
        //     if (i < k) {
        //         queue.offer(arr[i]);
        //     } else if (arr[i] < queue.peek()) {
        //         queue.poll();
        //         queue.offer(arr[i]);
        //     }
        // }
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 3;
        int minKth = findMinKth(arr, k);
        System.out.println(minKth);
    }
}
