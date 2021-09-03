package com.lyx.geek.AlgoMei.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author lvyunxiao
 * @date 2021/8/3
 * @description
 */
public class TopKCount {

    /**
     * 求数据中前K大数据
     */
    public int[] topk(int[] data, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < data.length; i++) {
            if (heap.size() < k) {
                heap.add(data[i]);
            } else {
                if (data[i] > heap.peek()) {
                    heap.remove();
                    heap.add(data[i]);
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {5, 3, 4, 1, 2};
        int k = 3;
        TopKCount topKCount = new TopKCount();
        int[] topk = topKCount.topk(data, k);
        System.out.println(Arrays.toString(topk));
    }

}
