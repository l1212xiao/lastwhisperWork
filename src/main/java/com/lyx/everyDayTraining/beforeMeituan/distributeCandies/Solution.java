package com.lyx.everyDayTraining.beforeMeituan.distributeCandies;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/5
多线程 */
public class Solution {
    // https://leetcode-cn.com/problems/distribute-candies/
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    // https://leetcode-cn.com/problems/distribute-candies-to-people/
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }

}
