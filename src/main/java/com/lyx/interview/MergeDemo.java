package com.lyx.interview;

/*
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: intervals = [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author lyx
 * @create 2020-10-11 22:35
 */
public class MergeDemo {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] peek = queue.peekLast();
            if (peek[1] >= intervals[i][0]) {
                queue.pollLast();
                queue.add(new int[]{
                        Math.min(peek[0], intervals[i][0]),
                        Math.max(peek[1], intervals[i][1])
                });
            } else {
                queue.offer(intervals[i]);
            }
        }
        int size = queue.size();
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        MergeDemo mergeDemo = new MergeDemo();
        // int[][] intervals = {
        //         {1, 3}, {2, 6}, {8, 10}, {15, 18}
        // };
        //[[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
        // [[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
        int[][] intervals = {
                {2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}
        };
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        for (int[] ints : intervals) {
            System.out.print(Arrays.toString(ints) + " , ");
        }
        System.out.println();
        int[][] merge = mergeDemo.merge(intervals);
        for (int[] ints : merge) {
            System.out.print(Arrays.toString(ints) + " , ");
        }
    }
}
