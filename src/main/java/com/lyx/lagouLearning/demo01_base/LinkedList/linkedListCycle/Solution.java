package com.lyx.lagouLearning.demo01_base.LinkedList.linkedListCycle;

import com.lyx.lagouLearning.demo01_base.LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/2
 * <p>
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
