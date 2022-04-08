package com.lyx.everyDayTraining.notOnlyMicro.listnode.partitionList;

/*
86. 分隔链表
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
你应当 保留 两个分区中每个节点的初始相对位置。

示例 1：

输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]

示例 2：

输入：head = [2,1], x = 2
输出：[1,2]

提示：
    链表中节点的数目在范围 [0, 200] 内
    -100 <= Node.val <= 100
    -200 <= x <= 200

 */


import com.lyx.everyDayTraining.notOnlyMicro.listnode.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/3/23
 * @description
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null) {
            if (head.val < x) {
                cur.next = head;
                cur = cur.next;
            } else {
                list.add(head);
            }
            head = head.next;
        }
        for (int i = 0; i < list.size(); i++) {
            cur.next = list.get(i);
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }


    public static void main(String[] args) {
        // 输入：head = [1,4,3,2,5,2], x = 3
        ListNode node6 = new ListNode(2);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(4, node3);
        ListNode node1 = new ListNode(1, node2);
        int x = 3;

        System.out.println(ListNode.printListNode(node1));

        Solution s = new Solution();
        ListNode partition = s.partition(node1, x);

        System.out.println(ListNode.printListNode(partition));

    }
}
