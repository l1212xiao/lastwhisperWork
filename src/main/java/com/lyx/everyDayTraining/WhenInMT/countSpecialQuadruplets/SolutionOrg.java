package com.lyx.everyDayTraining.WhenInMT.countSpecialQuadruplets;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyunxiao
 * @date 2021/12/29
 * @description
 */
public class SolutionOrg {

    // 方法一：直接枚举
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int a = 0; a < n; ++a) {
            for (int b = a + 1; b < n; ++b) {
                for (int c = b + 1; c < n; ++c) {
                    for (int d = c + 1; d < n; ++d) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            ++ans;
                        }
                    }
                }
            }
        }
        return ans;
    }

    // 方法二：使用哈希表存储 nums[d]
    public int countQuadruplets2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int c = n - 2; c >= 2; --c) {
            cnt.put(nums[c + 1], cnt.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < c; ++a) {
                for (int b = a + 1; b < c; ++b) {
                    ans += cnt.getOrDefault(nums[a] + nums[b] + nums[c], 0);
                }
            }
        }
        return ans;
    }


    // 方法三：使用哈希表存储 nums[d]−nums[c]
    public int countQuadruplets3(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2; d < n; d++) {
                cnt.put(nums[d] - nums[b + 1], cnt.getOrDefault(nums[d] - nums[b + 1], 0));
            }
            for (int a = 0; a < b; a++) {
                ans += cnt.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return ans;
    }
}
