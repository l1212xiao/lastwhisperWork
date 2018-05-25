package com.lyx.Array.MajorityElement;

/**
 * Created by lyx on 2018/5/25.
 * 169. Majority Element
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        int maxNum = 0;
        int majNum = nums[0];
        /*for (Integer val : map.values()) {
            maxValue = Math.max(val, maxValue);
        }*/
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer) entry.getValue() > maxNum) {
                maxNum = (Integer) entry.getValue();
                majNum = (Integer) entry.getKey();
            }
        }

        return majNum;

    }
}
