package com.lyx.Tree.postorderTraversal;

import com.lyx.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lyx on 2018/5/3.
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.peek();
                if (cur.right != null && pre != cur.right) {
                    root = cur.right;
                } else {
                    stack.pop();
                    list.add(cur.val);
                    pre = cur;
                }
            }
        }
        return list;
    }
}
