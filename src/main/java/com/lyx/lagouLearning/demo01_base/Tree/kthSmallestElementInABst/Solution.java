package com.lyx.lagouLearning.demo01_base.Tree.kthSmallestElementInABst;


import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/7
 */
public class Solution {

    private List<Integer> nodeList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        traversalTree1(root);
        return this.nodeList.get(k - 1);
    }

    public void traversalTree(TreeNode root) {
        if (root != null) {
            traversalTree(root.left);
            this.nodeList.add(root.val);
            traversalTree(root.right);
        }
    }

    public void traversalTree1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                this.nodeList.add(node.val);
                if (root != null) {
                    root = node.right;
                }
            }
        }
    }

    @Test
    public void testTraversal() {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
//
//        node1.left = node2;
//        node1.right = node3;
//
//        node2.left = node4;
//        node2.right = node5;
//
//        node3.left = node6;
//        node3.right = node7;

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        node2.right = node4;

        node3.left = node5;

        Solution solution = new Solution();
        final int i = solution.kthSmallest(node1, 1);
        System.out.println(i);
    }

}
