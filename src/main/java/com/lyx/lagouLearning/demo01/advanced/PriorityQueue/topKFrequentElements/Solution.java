package com.lyx.lagouLearning.demo01.advanced.PriorityQueue.topKFrequentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/12
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (final int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * ref:https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode/
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // build output list
        List<Integer> topK = new LinkedList();
        while (!heap.isEmpty()) {
            topK.add(heap.poll());
        }
        // sort if needed, all right if not need
        Collections.reverse(topK);
        return topK;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> list = solution.topKFrequent2(ints, k);
        System.out.println(list);
    }
}
