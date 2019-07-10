package com.lyx.leetcode.Numbers.TwoSumIIInputArrayIsSorted;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyx on 2018/5/14.
 * 167. Two Sum II - Input array is sorted
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] resNums = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                resNums[0] = i + 1;
                resNums[1] = map.get(target - numbers[i]) + 1;
            }
            map.put(numbers[i], i);
        }

        if (resNums[0] > resNums[1]) {
            resNums[0] = resNums[0] ^ resNums[1];
            resNums[1] = resNums[0] ^ resNums[1];
            resNums[0] = resNums[0] ^ resNums[1];
        }

        return resNums;
    }
}
