package com.lyx.lagouLearning.demo08_highFreq.lc_23;

import com.lyx.lagouLearning.demo01_base.LinkedList.ListNode;

import java.util.PriorityQueue;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/18
 * <p>
 * 23. 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution {

    // 最小堆法
    public ListNode mergeKLists(ListNode[] lists) {
        // 利用一个空的链表头方便插入节点。
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
        int k = lists.length;
        if (lists == null || k == 0) {
            return null;
        }

        //定义一个最小堆来保存k个链表节点；将k个链表的头放入到最小堆里。
        PriorityQueue<ListNode> heap = new PriorityQueue<>(k, (o1, o2) -> o1.val - o2.val);

        // 将所给链表插入到最小堆中
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            p.next = node;
            p = p.next;
            //如果发现该节点后面还有后续节点，将后续节点加入到最小堆里。
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return fakeHead.next;
    }

    // 分治法
    public ListNode mergeKLists(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }
        // 切分
        int mid = (low + high) / 2;
        return mergeTwoLists(mergeKLists(lists, low, mid), mergeKLists(lists, mid + 1, high));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val <= b.val) {
            a.next = mergeTwoLists(a.next, b);
            return a;
        }
        b.next = mergeTwoLists(a, b.next);
        return b;
    }
}
