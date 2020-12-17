package com.lyx.everyDayTraining.beforeMeituan.binaryTreePaths;


import com.lyx.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/9/4
 * <p>
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 */
public class Solution {
    /*
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructpath(root, "", paths);
        return paths;
    }

    // public void constructpath(TreeNode root, String path, List<String> paths) {
    //     if (root == null) {
    //         return;
    //     }
    //     path += root.val;
    //     if (root.left == null && root.right == null) {
    //         paths.add(path);
    //     } else {
    //         path += "->";
    //         constructpath(root.left, path, paths);
    //         constructpath(root.right, path, paths);
    //     }
    // }

    public void constructpath(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuilder sPath = new StringBuilder(path);
        sPath.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(sPath.toString());
        } else {
            sPath.append("->");
            constructpath(root.left, sPath.toString(), paths);
            constructpath(root.right, sPath.toString(), paths);
        }
    }
}
