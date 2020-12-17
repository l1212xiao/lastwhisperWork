package com.lyx.everyDayTraining.beforeMeituan.binaryTreePostorderTraversal;

/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
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
public class Solution2 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 查看栈顶的元素，如果该元素右孩子非空切未被访问，将该右孩子赋给遍历元素，否则出栈访问，并将该元素赋给pre元素
                TreeNode cur = stack.peek();
                if (cur.right != null && cur.right != pre) {
                    root = cur.right;
                } else {
                    stack.pop();
                    ans.add(cur.val);
                    pre = cur;
                }
            }
        }
        return ans;
    }
}
