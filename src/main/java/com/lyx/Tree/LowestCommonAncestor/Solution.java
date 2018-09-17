package com.lyx.Tree.LowestCommonAncestor;

import com.lyx.Tree.TreeNode;

/**
 * Created by lyx on 2018/8/22.
 * leetcode 235. 二叉搜索树的最近公共祖先
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

}
