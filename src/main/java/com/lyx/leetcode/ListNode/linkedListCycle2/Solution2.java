package com.lyx.ListNode.linkedListCycle2;

import com.lyx.ListNode.ListNode;

/**
 * Created by lyx on 2018/5/11.
 */
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}

