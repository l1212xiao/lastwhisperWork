package com.lyx.Tree.binaryTreeLevelOrderTraversal;

import com.lyx.Tree.TreeNode;

import java.util.List;

/**
 * Created by lyx on 2018/4/23.
 */
public class Test {
    public static void main(String[] args) {

        TreeNode a1 = new TreeNode(3);
        TreeNode b1 = new TreeNode(9);
        TreeNode b2 = new TreeNode(20);
        TreeNode c3 = new TreeNode(15);
        TreeNode c4 = new TreeNode(7);

        a1.left = b1;
        a1.right = b2;

        b2.left = c3;
        b2.right = c4;

        Solution solution = new Solution();
        printTreeNode(solution.levelOrderBottem(a1));

    }

    public static void printTreeNode(List<List<Integer>> list) {
        for (List<Integer> list1 : list) {
            for (int i : list1) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
