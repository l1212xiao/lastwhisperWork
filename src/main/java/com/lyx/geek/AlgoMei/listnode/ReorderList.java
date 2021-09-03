package com.lyx.geek.AlgoMei.listnode;

/*
143. 重排链表
给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 L0 → L1 → … → Ln-1 → Ln
请将其重新排列后变为：
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

输入: head = [1,2,3,4]
输出: [1,4,2,3]

示例 2:

输入: head = [1,2,3,4,5]
输出: [1,5,2,4,3]

 */


/**
 * @author lvyunxiao
 * @date 2021/8/19
 * @description
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode tail = head;
        ListNode tailPre = null;
        while (tail.next != null) {
            tailPre = tail;
            tail = tail.next;
        }

        tailPre.next = null;
        ListNode next = head.next;
        head.next = tail;
        tail.next = next;
        reorderList(next);
    }

    // 找中点+反转后半部分+合并前后两部分
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // 1. 找中点，让slow指向中点，或左中点位置
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 断开中点，反转后半部分
        ListNode head2 = null, next = slow.next;
        slow.next = null;
        slow = next;
        while (slow != null) {
            next = slow.next;
            slow.next = head2;
            head2 = slow;
            slow = next;
        }

        // 3. 合并链表head和head2
        ListNode curr = head;
        ListNode curr2 = head2;
        while (curr != null && curr2 != null) {
            next = curr.next;
            curr.next = curr2;
            curr2 = curr2.next;
            curr.next.next = next;
            curr = next;
        }
    }

    public static void main(String[] args) {

        ReorderList s = new ReorderList();
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode head = new ListNode(1, l2);
        printListNode(head);
        s.reorderList2(head);
        printListNode(head);

    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

}
