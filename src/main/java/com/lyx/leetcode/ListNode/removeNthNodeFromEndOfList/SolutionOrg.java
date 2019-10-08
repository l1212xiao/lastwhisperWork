package com.lyx.leetcode.ListNode.removeNthNodeFromEndOfList;

import com.lyx.leetcode.ListNode.ListNode;

/**
 * @Classname SolutionOrg
 * @Description SolutionOrg
 * @Date 2019/9/27
 * @auther lvyunxiao
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
 */
public class SolutionOrg {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        length -= n;
        cur = dummy;
        while (length > 0) {
            cur = cur.next;
            length--;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
