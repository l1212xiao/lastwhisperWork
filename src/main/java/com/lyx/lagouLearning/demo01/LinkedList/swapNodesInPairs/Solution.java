package com.lyx.lagouLearning.demo01.LinkedList.swapNodesInPairs;

import com.lyx.lagouLearning.demo01.LinkedList.ListNode;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/2
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;

        ListNode listNode = solution.swapPairs(l1);
        ListNode.printListNode(listNode);

    }
}
