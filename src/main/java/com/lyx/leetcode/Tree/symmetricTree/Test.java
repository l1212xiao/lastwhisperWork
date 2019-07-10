package com.lyx.leetcode.Tree.symmetricTree;

import com.lyx.leetcode.Tree.TreeNode;

/**
 * Created by lyx on 2018/4/17.
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(2);
        //TreeNode b1 = new TreeNode(3);
        TreeNode b2 = new TreeNode(3);
        //TreeNode b3 = new TreeNode(4);
        TreeNode b4 = new TreeNode(3);

        root.left = a1;
        root.right = a2;

        //a1.left = b1;
        a1.right = b2;
        //a2.left = b3;
        a2.right = b4;

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
    }
}
