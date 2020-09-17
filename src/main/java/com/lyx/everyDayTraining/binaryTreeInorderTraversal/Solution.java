package com.lyx.everyDayTraining.binaryTreeInorderTraversal;

/*
94. 二叉树的中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 */

import com.lyx.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @date 2020/9/14
 */
public class Solution {
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     inorderTraversal(root, ans);
    //     return ans;
    // }
    //
    // public void inorderTraversal(TreeNode root, List<Integer> ans) {
    //     if (root == null) {
    //         return;
    //     }
    //     Stack<TreeNode> stack = new Stack<>();
    //     while (!stack.isEmpty() || root != null) {
    //         if (root != null) {
    //             stack.push(root);
    //             root = root.left;
    //         } else {
    //             TreeNode node = stack.pop();
    //             ans.add(node.val);
    //             root = node.right;
    //         }
    //     }
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                ans.add(node.val);
                root = node.right;
            }
        }
        return ans;
    }

}
