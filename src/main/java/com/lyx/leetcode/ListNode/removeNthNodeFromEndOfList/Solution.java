package com.lyx.leetcode.ListNode.removeNthNodeFromEndOfList;

import com.lyx.leetcode.ListNode.ListNode;

/**
 * @Classname Solution
 * @Description Solution
 * @Date 2019/9/27
 * @auther lvyunxiao
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode resultHead = head;
        ListNode cur = head;
        int listLength = getListLength(head);
        if (listLength < n) {
            return null;
        }
        int dictance = listLength - n;
        if (dictance == 0) {
            return head.next;
        }
        while (dictance > 1) {
            cur = cur.next;
            dictance--;
        }
        if (cur.next == null) {
            return null;
        }
        cur.next = cur.next.next;
        return resultHead;
    }

    public static int getListLength(ListNode listNode) {
        int count = 0;
        ListNode cur = listNode;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            if (listNode.next == null) {
                System.out.print(listNode.val);
            } else {
                System.out.print(listNode.val + "->");
            }
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        //int listLength = getListLength(listNode1);
        //System.out.println(listLength);

        ListNode listNode11 = new ListNode(1);

        Solution solution = new Solution();
        ListNode listNode = solution.removeNthFromEnd(listNode11, 1);
        printListNode(listNode);


    }
}
