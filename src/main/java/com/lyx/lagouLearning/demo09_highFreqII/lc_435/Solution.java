package com.lyx.lagouLearning.demo09_highFreqII.lc_435;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/20
 * <p>
 * 435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 *
 * 超时！
 */
public class Solution {

    // 在主体函数里，先将区间按照起始时间的先后顺序排序，然后调用递归函数
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        return eraseOverlapIntervals(-1, 0, intervals);
    }

    // 递归函数里，先检查是否已经处理完所有的区间，是，表明不需要删除操作，直接返回
    public int eraseOverlapIntervals(int pre, int cur, int[][] intervals) {
        if (cur == intervals.length) {
            return 0;
        }
        int taken = Integer.MAX_VALUE, nottaken;
        // 只有当pre, cur没有发生重叠的时候，才可以选择保留当前的区间curr
        if (pre == -1 || intervals[pre][1] <= intervals[cur][0]) {
            taken = eraseOverlapIntervals(cur, cur + 1, intervals);
        }
        // 其他情况，可以考虑删除掉curr区间，看看删除了它之后会不会产生最好的结果
        nottaken = eraseOverlapIntervals(pre, cur + 1, intervals) + 1;

        // 返回较小值
        return Math.min(taken, nottaken);
    }
}
