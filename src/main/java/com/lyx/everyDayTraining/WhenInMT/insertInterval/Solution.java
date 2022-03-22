package com.lyx.everyDayTraining.WhenInMT.insertInterval;

/*
57. 插入区间

给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
示例 1：

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]

示例 2：

输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

示例 3：

输入：intervals = [], newInterval = [5,7]
输出：[[5,7]]

示例 4：

输入：intervals = [[1,5]], newInterval = [2,3]
输出：[[1,5]]

示例 5：

输入：intervals = [[1,5]], newInterval = [2,7]
输出：[[1,7]]



提示：
    0 <= intervals.length <= 10^4
    intervals[i].length == 2
    0 <= intervals[i][0] <= intervals[i][1] <= 10^5
    intervals 根据 intervals[i][0] 按 升序 排列
    newInterval.length == 2
    0 <= newInterval[0] <= newInterval[1] <= 10^5
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/2/28
 * @description
 */
public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addFirst(newInterval);

        for (int[] interval : intervals) {
            int l1 = interval[0];
            int r1 = interval[1];
            int[] pop = queue.pollLast();
            int l2 = pop[0];
            int r2 = pop[1];
            if ((r1 < l2)) {
                queue.addLast(interval);
                queue.addLast(pop);
            } else if (l1 > r2) {
                queue.addLast(pop);
                queue.addLast(interval);
            } else if ((l1 <= l2) || (r1 >= r2)) {
                int[] toAdd = new int[2];
                toAdd[0] = Math.min(l1, l2);
                toAdd[1] = Math.max(r1, r2);
                queue.add(toAdd);
            } else {
                queue.add(pop);
            }
        }

        int n = queue.size();
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public int[][] insertOrg(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    // 作者：LeetCode-Solution
    // 链接：https://leetcode-cn.com/problems/insert-interval/solution/cha-ru-qu-jian-by-leetcode-solution/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Solution s = new Solution();
        // 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        // int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        // int[] newInterval = {4, 8};

        int[][] intervals = {{2, 6}, {7, 9}};
        int[] newInterval = {15, 18};

        int[][] insert = s.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(insert));
    }
}
