package com.lyx.everyDayTraining.notOnlyMicro.tree;

/**
 * @author lvyunxiao
 * @date 2022/3/23
 * @description
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
