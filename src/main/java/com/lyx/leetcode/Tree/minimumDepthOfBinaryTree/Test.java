package com.lyx.Tree.minimumDepthOfBinaryTree;


import com.lyx.Tree.TreeNode;

/**
 * Created by lyx on 2018/4/28.
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        root.left = a1;

        Solution solution = new Solution();

        int minD = solution.minDepth(root);

        System.out.println(minD);

    }
}
