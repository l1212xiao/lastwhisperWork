package com.lyx.leetcode.Tree.balancedBinaryTree;

import com.lyx.leetcode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lyx on 2018/4/28.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        boolean isB = true;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Math.abs(getDepth(node.left) - getDepth(node.right)) > 1) return false;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return isB;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        }
    }
}
