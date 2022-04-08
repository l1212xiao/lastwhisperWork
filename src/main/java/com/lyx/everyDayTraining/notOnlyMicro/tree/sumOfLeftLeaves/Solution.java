package com.lyx.everyDayTraining.notOnlyMicro.tree.sumOfLeftLeaves;

/*
404. 左叶子之和

给定二叉树的根节点 root ，返回所有左叶子之和。
示例 1：

输入: root = [3,9,20,null,null,15,7]
输出: 24
解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

示例 2:

输入: root = [1]
输出: 0

 */


import com.lyx.everyDayTraining.notOnlyMicro.tree.TreeNode;

/**
 * @author lvyunxiao
 * @date 2022/3/28
 * @description
 */
public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            if (isLeaf(root.left)) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
