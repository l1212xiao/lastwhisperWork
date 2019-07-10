package com.lyx.leetcode.Tree.pathSum;

import com.lyx.leetcode.Tree.TreeNode;


/**
 * Created by lyx on 2018/4/28.
 * 112. Path Sum
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val ? true : false;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
