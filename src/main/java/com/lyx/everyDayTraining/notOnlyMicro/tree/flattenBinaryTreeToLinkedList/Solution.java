package com.lyx.everyDayTraining.notOnlyMicro.tree.flattenBinaryTreeToLinkedList;

/*
114. 二叉树展开为链表

给你二叉树的根结点 root ，请你将它展开为一个单链表：
    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    展开后的单链表应该与二叉树 先序遍历 顺序相同。

示例 1：

输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]

示例 2：

输入：root = []
输出：[]

示例 3：

输入：root = [0]
输出：[0]

提示：
    树中结点数在范围 [0, 2000] 内
    -100 <= Node.val <= 100

进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？

 */


import com.lyx.everyDayTraining.notOnlyMicro.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/3/23
 * @description
 */
public class Solution {

    // 先序遍历
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrderTraversal(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode cur = list.get(i);
            TreeNode next = list.get(i + 1);
            cur.left = null;
            cur.right = next;
        }
    }

    private void preOrderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        }
    }

    // 寻找前驱节点
    // 具体做法是，对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点，将当前节点的右子节点赋给前驱节点的右子节点，
    // 然后将当前节点的左子节点赋给当前节点的右子节点，并将当前节点的左子节点设为空。
    // 对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束。
    public void flattern(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }



}
