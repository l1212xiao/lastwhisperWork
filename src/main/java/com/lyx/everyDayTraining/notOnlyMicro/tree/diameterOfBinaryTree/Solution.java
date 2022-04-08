package com.lyx.everyDayTraining.notOnlyMicro.tree.diameterOfBinaryTree;

/*
543. 二叉树的直径

给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5

返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
注意：两结点之间的路径长度是以它们之间边的数目表示。
 */


import com.lyx.everyDayTraining.notOnlyMicro.tree.TreeNode;

/**
 * @author lvyunxiao
 * @date 2022/3/28
 * @description
 */
public class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = getHeight(root.left) + getHeight(root.right);
        max = Math.max(diameterOfBinaryTree(root.left), max);
        max = Math.max(diameterOfBinaryTree(root.right), max);
        return max;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
