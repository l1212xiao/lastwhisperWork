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
public class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // close the linked list into the ring
        ListNode oldTail = head;
        int n;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // break the ring
        newTail.next = null;

        return newHead;
    }

    // 作者：LeetCode
    // 链接：https://leetcode-cn.com/problems/rotate-list/solution/xuan-zhuan-lian-biao-by-leetcode/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    public static void main(String[] args) {
        Solution2 s = new Solution2();
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
        // int length = s.getLength(l1);
        // System.out.println("length is: " + length);
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
