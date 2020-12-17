package com.lyx.everyDayTraining.beforeMeituan.swapNodesInPairs;

/*
24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
示例 1：

输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]
 */


import com.lyx.leetcode.ListNode.ListNode;

/**
 * @author lvyunxiao
 * @date 2020/10/13
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next.next;
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = swapPairs(temp);
        return newHead;
    }
}
