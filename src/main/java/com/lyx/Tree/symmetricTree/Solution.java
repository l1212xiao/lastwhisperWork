package com.lyx.Tree.symmetricTree;

import com.lyx.Tree.TreeNode;

/**
 * Created by lyx on 2018/4/17.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode cur = root;
        if (cur == null)
            return true;
        if (cur.left == null && cur.right == null)
            return true;
        if (cur.left == null || cur.right == null)
            return false;
        if (cur.left.val != cur.right.val)
            return false;
        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
        if (isSymmetric(cur.left) && isSymmetric(cur.right))
            return true;
        return true;
    }
}
