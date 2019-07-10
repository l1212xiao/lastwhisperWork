package com.lyx.leetcode.ListNode.addTwoNumbers;

import com.lyx.leetcode.ListNode.ListNode;

/**
 * Created by lyx on 2018/7/6.
 */
public class SolutionTest {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return combine(l1, l2, 0);
    }

    public ListNode combine(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int value1 = l1 == null ? 0 : l1.val;
        int value2 = l2 == null ? 0 : l2.val;

        int sum = value1 + value2 + carry;
        carry = sum > 9 ? 1 : 0;

        int value = sum - 10 >= 0 ? sum - 10 : sum;
        ListNode combined = new ListNode(value);

        ListNode l1Next = l1 == null ? null : l1.next;
        ListNode l2Next = l2 == null ? null : l2.next;

        combined.next = combine(l1Next, l2Next, carry);

        return combined;
    }
}
