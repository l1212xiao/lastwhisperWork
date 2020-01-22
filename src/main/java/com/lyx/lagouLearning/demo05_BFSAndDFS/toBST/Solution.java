package com.lyx.lagouLearning.demo05_BFSAndDFS.toBST;

import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/1/21
 * <p>
 * 108. 将有序数组转换为二叉搜索树
 * 分析
 * 按照二分的思想。中点作为根节点。
 * 中点左边的数作为左子树，中点右边的数作为右子树。
 * <p>
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-24/
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }

}
