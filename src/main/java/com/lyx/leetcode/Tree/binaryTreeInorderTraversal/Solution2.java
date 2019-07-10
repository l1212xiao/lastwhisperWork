package com.lyx.leetcode.Tree.binaryTreeInorderTraversal;

import com.lyx.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lyx on 2018/5/3.
 */
public class Solution2 {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;

    }
}
