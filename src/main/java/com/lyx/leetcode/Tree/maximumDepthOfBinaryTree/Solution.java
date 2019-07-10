package com.lyx.leetcode.Tree.maximumDepthOfBinaryTree;

import com.lyx.leetcode.Tree.TreeNode;

/**
 * Created by lyx on 2018/4/23.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
