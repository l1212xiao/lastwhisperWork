package com.lyx.lagouLearning.demo01_base.LinkedList.reverseNodesInKGroup;

import com.lyx.lagouLearning.demo01_base.LinkedList.ListNode;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/2
 */
public class Solution {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode start, end;
        start = end = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverseList(start, end);
        // 递归反转后续链表并连接起来
        start.next = reverseKGroup(end, k);
        return newHead;
    }
}
