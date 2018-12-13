package com.lyx.Tree.sameTree;

import com.lyx.Tree.TreeNode;

/**
 * Created by lyx on 2018/4/16.
 */
public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
