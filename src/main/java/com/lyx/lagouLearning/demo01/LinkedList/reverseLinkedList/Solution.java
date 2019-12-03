package com.lyx.lagouLearning.demo01.LinkedList.reverseLinkedList;

import com.lyx.lagouLearning.demo01.LinkedList.ListNode;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/2
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            // 保存cur节点的next指针
            ListNode nextTemp = cur.next;
            // 反转
            cur.next = pre;
            // 向后迭代
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }

    public ListNode reverseList(ListNode start, ListNode end) {
        if (start == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = start;

        while (cur != end) {
            // 保存cur节点的next指针
            ListNode nextTemp = cur.next;
            // 反转
            cur.next = pre;
            // 向后迭代
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        //ListNode listNode = solution.reverseList(l1);
        //ListNode.printListNode(listNode);

        ListNode listNode1 = solution.reverseList(l1, l3);
        ListNode.printListNode(listNode1);
    }
}
