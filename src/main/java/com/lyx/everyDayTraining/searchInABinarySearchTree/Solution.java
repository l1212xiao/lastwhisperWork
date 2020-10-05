package com.lyx.everyDayTraining.searchInABinarySearchTree;

/*
700. 二叉搜索树中的搜索
给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。

例如，

给定二叉搜索树:

        4
       / \
      2   7
     / \
    1   3

和值: 2
你应该返回如下子树:

      2
     / \
    1   3
 */

import com.lyx.leetcode.Tree.TreeNode;

/**
 * @author lvyunxiao
 * @date 2020/9/30
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (val == cur.val) {
                return cur;
            } else if (val > cur.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }
}
