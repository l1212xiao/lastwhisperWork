package com.lyx.interview.threeOrder;

import com.lyx.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> in = new ArrayList<>();
    ArrayList<Integer> post = new ArrayList<>();

    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        int[][] result = new int[3][];
        preOrder(root);
        inOrder(root);
        postOrder(root);
        result[0] = toIntArray(pre);
        result[1] = toIntArray(in);
        result[2] = toIntArray(post);
        return result;
    }

    //先序
    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            pre.add(node.val);
            //右结点先入栈，左结点后入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //中序
    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                in.add(node.val);
                root = node.right;
            }
        }
    }

    //后序
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
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
                    post.add(cur.val);
                    pre = cur;
                }
            }
        }
    }

    // 将ArrayList转换为整型数组
    private int[] toIntArray(ArrayList<Integer> list) {
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
        // return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;
        int[][] ints = new Solution().threeOrders(root);
        System.out.println(Arrays.deepToString(ints));
    }
}
