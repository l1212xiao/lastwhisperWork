package com.lyx.everyDayTraining.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
方法一：迭代法实现子集枚举
思路与算法

记原序列中元素的总数为 nn。原序列中的每个数字 a_ia
i
​
  的状态可能有两种，即「在子集中」和「不在子集中」。我们用 11 表示「在子集中」，00 表示不在子集中，那么每一个子集可以对应一个长度为 nn 的 0/10/1 序列，第 ii 位表示 a_ia
i
​
  是否在子集中。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution2 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            path.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    path.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(path));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = s.subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(Arrays.toString(subset.toArray()));
        }
    }

}
