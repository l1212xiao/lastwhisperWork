package com.lyx.geek.AlgoMei.listnode;

/*
82. 删除排序链表中的重复元素 II

存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
返回同样按升序排列的结果链表。

示例 1：

输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]

示例 2：

输入：head = [1,1,1,2,3]
输出：[2,3]

 */

/**
 * @author lvyunxiao
 * @date 2021/8/20
 * @description
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;

        if (newHead.val == newHead.next.val) {
            int val = newHead.val;
            while (newHead != null && val == newHead.val) {
                newHead = newHead.next;
            }
            return deleteDuplicates(newHead);
        } else {
            newHead.next = deleteDuplicates(newHead.next);
            return newHead;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII s = new RemoveDuplicatesFromSortedListII();
        ListNode l7 = new ListNode(5);
        ListNode l6 = new ListNode(4, l7);
        ListNode l5 = new ListNode(4, l6);
        ListNode l4 = new ListNode(3, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode head = new ListNode(1, l2);
        printListNode(head);
        ListNode deleteDuplicates = s.deleteDuplicates(head);
        printListNode(deleteDuplicates);
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

}
