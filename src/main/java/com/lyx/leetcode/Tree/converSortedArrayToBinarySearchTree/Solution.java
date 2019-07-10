package com.lyx.leetcode.Tree.converSortedArrayToBinarySearchTree;

import com.lyx.leetcode.Tree.TreeNode;

/**
 * Created by lyx on 2018/4/28.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);

    }

    public TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, low, mid - 1);
        node.right = buildTree(nums, mid + 1, high);
        return node;
    }

}
