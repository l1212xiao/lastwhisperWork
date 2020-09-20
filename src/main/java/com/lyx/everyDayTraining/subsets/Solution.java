package com.lyx.everyDayTraining.subsets;

/*
78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther lvyunxiao
 * @date 2020-09-20
 */
public class Solution {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // no choice
        dfs(cur + 1, nums);

        // choice
        path.add(nums[cur]);
        dfs(cur + 1, nums);
        path.remove(path.size() - 1);

    }

    // 作者：LeetCode-Solution
    // 链接：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode-solution/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = s.subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(Arrays.toString(subset.toArray()));
        }
    }
}
