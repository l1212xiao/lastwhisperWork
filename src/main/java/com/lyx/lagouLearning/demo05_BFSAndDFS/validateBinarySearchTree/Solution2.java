package com.lyx.lagouLearning.demo05_BFSAndDFS.validateBinarySearchTree;

import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;

import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution2
 * @description Solution2
 * @date 2020/1/21
 * <p>
 * 98. 验证二叉搜索树
 * <p>
 * 中序遍历
 * 算法
 * <p>
 * 我们使用
 * 中序遍历
 * 左子树 -> 结点 -> 右子树 意味着对于二叉搜索树而言，每个元素都应该比下一个元素小。
 */
public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double preVal = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= preVal) {
                return false;
            }
            preVal = root.val;
            root = root.right;
        }
        return true;
    }

}
