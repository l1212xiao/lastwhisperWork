package com.lyx.everyDayTraining.notOnlyMicro.listnode;

/**
 * @author lvyunxiao
 * @date 2022/3/22
 * @description
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static String printListNode(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = node;
        while (cur != null) {
            sb.append(cur.val);
            sb.append("->");
            cur = cur.next;
        }
        return sb.toString();
    }

}
