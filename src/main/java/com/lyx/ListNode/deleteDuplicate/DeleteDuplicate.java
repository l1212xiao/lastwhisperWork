package com.lyx.ListNode.deleteDuplicate;

import com.lyx.ListNode.ListNode;

/**
 * Created by lyx on 2018/9/19
 */
public class DeleteDuplicate {
    public static void deleteDuplicateNode(ListNode head) {
        ListNode cur = head;
        ListNode pre = cur;

        while (cur != null) {
            cur = cur.next;
            if (cur != null && cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;

        printListNode(node);
        deleteDuplicateNode(node);
        System.out.println("********");
        printListNode(node);


    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
