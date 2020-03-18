package com.lyx.lagouLearning.demo07_binarySearchAndGreedy.mettingRooms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/6
 * <p>
 * public class Interval {
 * *     int start;
 * *     int end;
 * *     Interval() { start = 0; end = 0; }
 * *     Interval(int s, int e) { start = s; end = e; }
 * * }
 * LeetCode 253会议室II
 * 给定一系列会议的起始时间和结束时间，求最少需要多少个会议室就可以让这些会议顺利召开。
 */
public class Solution {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        // 用一个最小堆来维护目前开辟的所有会议室，最小堆里的会议室按照会议的结束时间排序。
        // PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (o1, o2) -> o1.end - o2.end);
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        // 让第一个会议在第一个会议室里举行。
        heap.offer(intervals[0]);

        for (int i = 0; i < intervals.length; i++) {
            // 从第二个会议开始，对于每个会议，我们都从最小堆里取出一个会议室，那么这个会议室里的会议一定是最早结束的。
            Interval interval = heap.poll();
            if (intervals[i].start >= interval.end) {
                // 若当前要开的会议可以等会议室被腾出才开始，那么就可以重复利用这个会议室。
                interval.end = intervals[i].end;
            } else {
                // 否则，开一个新的会议室。
                heap.offer(intervals[i]);
            }
            // 把旧的会议室也放入到最小堆里。
            heap.offer(interval);
        }
        // 最小堆里的会议室个数就是要求的答案，即最少的会议个数。
        return heap.size();
    }
}
