package com.lyx.lagouLearning.demo01_base.LinkedList;

/**
 * @author lvyunxiao
 * @classname ListNode
 * @description ListNode
 * @date 2019/12/2
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            if (listNode.next != null) {
                System.out.print(listNode.val + "->");
            } else {
                System.out.println(listNode.val);
            }
            listNode = listNode.next;
        }
    }
}
