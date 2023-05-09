package com.lyx.interview.interview2022;

/*
有一个无序int数组，如果其中一个值大于等于他左右相邻的值(边界值只要满足单侧就可以)，

则认为他是peak点。数组可能包含多个peak点，在这种情况下，返回 任何一个peak 即可，要求时间复杂度为O(log(n))
例如
输入：{3,1,2,1,4,5,2,1,6}
输出：3 or 2 or 5 or 6
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    public int findPeek(int[] nums) {

        int begin = 0;
        int end = nums.length - 1;
        // int mid = 0;
        while (begin <= end) {
            int leftnum,rightnum;
            int mid = begin + (end  - begin) >> 1;
            leftnum = (mid == 0 ? Integer.MIN_VALUE : nums[mid - 1]);
            rightnum = (mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1]);
            if (nums[mid] >= leftnum && nums[mid] >= rightnum) {
                return nums[mid];
            } else if (leftnum > rightnum) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return nums[0];
    }

    public class BolockingQueue {
        int count ; // 队列长度
        int length ; // 队列长度
        // check
        ReentrantLock lock = new ReentrantLock();
        Queue<Integer> queue = new LinkedList<>();
        public boolean offer(Integer e) {

            // 获取锁
            lock.lock();
            try {
                //
                if (count == length) {
                    return false;
                } else {
                    // 进队
                    queue.add(e);
                }
            }finally {
                lock.unlock();
            }
            return true;
        }


        public  Integer poll() {
            ReentrantLock reentrantLock = this.lock;
            lock.lock(); // 获取锁
            try {
                return queue.poll();
            }finally {
                lock.unlock();
            }
        }
    }


}
