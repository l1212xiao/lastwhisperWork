package com.lyx.leetcode.ListNode.linkedListCycle;


import com.lyx.leetcode.ListNode.ListNode;

/**
 * Created by lyx on 2018/5/11.
 */
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
