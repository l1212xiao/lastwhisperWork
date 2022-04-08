package com.lyx.everyDayTraining.notOnlyMicro.tree.convertSortedListToBinarySearchTree;

/*
109. 有序链表转换二叉搜索树
给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。

示例 1:

输入: head = [-10,-3,0,5,9]
输出: [0,-3,9,-10,null,5]
解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。

示例 2:

输入: head = []
输出: []

提示:
    head 中的节点数在[0, 2 * 10^4] 范围内
    -10^5 <= Node.val <= 10^5


 */


import com.lyx.everyDayTraining.notOnlyMicro.listnode.ListNode;
import com.lyx.everyDayTraining.notOnlyMicro.tree.TreeNode;

/**
 * @author lvyunxiao
 * @date 2022/3/28
 * @description
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    private ListNode getMedian(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
