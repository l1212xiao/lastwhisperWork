package com.lyx.ListNode.reverseListNode;

import com.lyx.ListNode.ListNode;

/**
 * Created by lyx on 2018/9/21
 * 单链表反转
 */
public class Reverse {
    public static ListNode reverse(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;

        printListNode(node);
        ListNode reverseNode = reverse(node);
        System.out.println();
        System.out.println("********");
        printListNode(reverseNode);


    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
