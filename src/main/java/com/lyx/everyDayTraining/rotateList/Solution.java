package com.lyx.everyDayTraining.rotateList;

/*
61. 旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
 */


import com.lyx.leetcode.ListNode.ListNode;

/**
 * @author lvyunxiao
 * @date 2020/9/23
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int length = getLength(head);
        if (length > k) {
            k = k % length;
        }
        ListNode newHead = head;
        for (int i = 0; i < k; i++) {
            newHead = rotateRight(newHead);
        }
        return newHead;
    }

    public ListNode rotateRight(ListNode head) {
        int length = getLength(head);
        ListNode cur = head;
        for (int i = 1; i < length - 1; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        newHead.next = head;
        return newHead;
    }

    public int getLength(ListNode head) {
        int ans = 0;
        while (head != null) {
            head = head.next;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1->2->3->4->5

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        // ListNode l4 = new ListNode(4);
        // ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        // l3.next = l4;
        // l4.next = l5;
        printList(l1);
        int length = s.getLength(l1);
        System.out.println("length is: " + length);
        // ListNode listNode = s.rotateRight(l1);
        // printList(listNode);
        ListNode rotateRight = s.rotateRight(l1, 2000000000);
        printList(rotateRight);

    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("============");
    }
}
