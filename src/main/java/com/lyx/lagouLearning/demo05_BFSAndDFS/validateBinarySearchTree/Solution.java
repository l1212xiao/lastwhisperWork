package com.lyx.lagouLearning.demo05_BFSAndDFS.validateBinarySearchTree;

import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/1/21
 * 方法一: 递归
 * 上述思路可以用递归法实现。首先将结点的值与上界和下界（如果有）比较。然后，对左子树和右子树递归进行该过程。
 * <p>
 * https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode/
 */
public class Solution {

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.left, lower, val)) return false;
        if (!helper(node.right, val, upper)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

}
