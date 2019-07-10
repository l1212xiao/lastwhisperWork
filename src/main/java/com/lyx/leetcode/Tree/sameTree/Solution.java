package com.lyx.leetcode.Tree.sameTree;

import com.lyx.leetcode.Tree.TreeNode;

/**
 * Created by lyx on 2018/4/16.
 * 100. Same Tree
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSame = true;
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            isSame = false;
        } else if (p.val != q.val || !isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) {
            isSame = false;
        }
        return isSame;
    }
}
