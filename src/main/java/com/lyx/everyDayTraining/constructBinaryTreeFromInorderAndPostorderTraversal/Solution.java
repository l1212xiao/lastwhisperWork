package com.lyx.everyDayTraining.constructBinaryTreeFromInorderAndPostorderTraversal;

/*
106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

 */


import com.lyx.leetcode.Tree.TreeNode;

import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2020/9/25
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        int inLen = inorder.length;
        int postLen = postorder.length;
        int rootVal = postorder[postLen - 1];
        TreeNode root = new TreeNode(rootVal);
        int idx = getIdx(inorder, rootVal);
        int[] newLeftIn = Arrays.copyOfRange(inorder, 0, idx);
        int[] newRightIn = Arrays.copyOfRange(inorder, idx + 1, inLen);

        int[] newLeftPost = Arrays.copyOfRange(postorder, 0, newLeftIn.length);
        int[] newRightPost = Arrays.copyOfRange(postorder, newLeftIn.length, newLeftIn.length + newRightIn.length);

        root.left = buildTree(newLeftIn, newLeftPost);
        root.right = buildTree(newRightIn, newRightPost);

        return root;
    }

    // 前序 + 中序
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        int inLen = inorder.length;
        int preLen = preorder.length;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int idx = getIdx(inorder, rootVal);
        int[] newLeftIn = Arrays.copyOfRange(inorder, 0, idx);
        int[] newRightIn = Arrays.copyOfRange(inorder, idx + 1, inLen);

        int[] newLeftPre = Arrays.copyOfRange(preorder, 1, newLeftIn.length + 1);
        int[] newRightPre = Arrays.copyOfRange(preorder, idx + 1, preLen);

        root.left = buildTree(newLeftPre, newLeftIn);
        root.right = buildTree(newRightPre, newRightIn);

        return root;
    }

    public int getIdx(int[] inorder, int num) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
