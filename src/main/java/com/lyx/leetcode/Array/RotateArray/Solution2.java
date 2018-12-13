package com.lyx.Array.RotateArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyx on 2018/6/5.
 */
public class Solution2 {
    public void rotate(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        while (k > 0) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            k--;
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }
}
