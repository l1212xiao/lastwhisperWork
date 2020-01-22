package com.lyx.lagouLearning.demo05_BFSAndDFS.maximumDepthOfBinaryTree;

import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/1/21
 * <p>
 * 104. 二叉树的最大深度
 */
public class Solution {
    // 递归
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
