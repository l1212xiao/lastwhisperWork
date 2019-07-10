package com.lyx.leetcode.Tree.symmetricTree;

import com.lyx.leetcode.Tree.TreeNode;

/**
 * Created by lyx on 2018/4/17.
 */
public class Solution2 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return checkNodes(root.left, root.right);
        }
    }

    public boolean checkNodes(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 == null || n2 == null) {
            return false;
        } else if (n1.val != n2.val) {
            return false;
        } else {
            return checkNodes(n1.left, n2.right) && checkNodes(n1.right, n2.left);
        }
    }
}
