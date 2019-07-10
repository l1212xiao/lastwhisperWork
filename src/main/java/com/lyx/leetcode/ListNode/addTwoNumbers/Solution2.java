package com.lyx.leetcode.ListNode.addTwoNumbers;

import com.lyx.leetcode.ListNode.ListNode;

/**
 * Created by lyx on 2018/5/10.
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return combine(l1,l2,0);
    }

    public ListNode combine(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry ==  0) return null;
        int sum = (l1 != null ? l1.val : 0 ) + (l2 != null ? l2.val : 0) + carry;
        carry = sum > 9 ? 1 : 0;
        int value = sum - 10  >=  0 ? sum -10 : sum;

        ListNode combined = new ListNode(value);
        combined.next = combine(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
        return combined;
    }
}
