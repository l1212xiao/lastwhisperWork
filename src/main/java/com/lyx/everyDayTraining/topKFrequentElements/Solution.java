package com.lyx.everyDayTraining.topKFrequentElements;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lvyunxiao
 * @date 2020/9/7
 *
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * https://leetcode-cn.com/problems/top-k-frequent-elements/submissions/
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurs = new HashMap<>();
        for (int num : nums) {
            occurs.put(num, occurs.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        // PriorityQueue<int[]> heap = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        for (Map.Entry<Integer, Integer> entry : occurs.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (heap.size() == k) {
                if (heap.peek()[1] < count) {
                    heap.poll();
                    heap.offer(new int[]{num, count});
                }
            } else {
                heap.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Solution solution = new Solution();
        int[] topKFrequent = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(topKFrequent));
    }
}
