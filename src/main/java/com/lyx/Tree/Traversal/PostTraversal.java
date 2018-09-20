package com.lyx.Tree.Traversal;

import com.lyx.Tree.TreeNode;

import java.util.Stack;

/**
 * Created by lyx on 2018/9/19
 * 参考：
 * https://blog.csdn.net/zhuqiuhui/article/details/51319165
 */

public class PostTraversal {
    /*
     后序遍历，非递归实现
    */
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;

        //移到最左边
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        while (!stack.empty()) {
            cur = stack.pop();

            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (cur.right != null && cur.right != pre) {
                stack.push(cur);
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            } else {
                System.out.print(cur.val + " ");
                pre = cur;
            }
        }
    }

    public static void main(String[] args) {
        /**
         *          1
         *        /  \
         *       2    3
         *      / \  / \
         *     4  5 6  7
         *    /
         *   8
         */

        TreeNode root = new TreeNode(1);
        TreeNode Node2 = new TreeNode(2);
        TreeNode Node3 = new TreeNode(3);
        TreeNode Node4 = new TreeNode(4);
        TreeNode Node5 = new TreeNode(5);
        TreeNode Node6 = new TreeNode(6);
        TreeNode Node7 = new TreeNode(7);
        TreeNode Node8 = new TreeNode(8);

        root.left = Node2;
        root.right = Node3;

        Node2.left = Node4;
        Node2.right = Node5;

        Node3.left = Node6;
        Node3.right = Node7;

        Node4.left = Node8;

        postOrder(root);

    }
}
