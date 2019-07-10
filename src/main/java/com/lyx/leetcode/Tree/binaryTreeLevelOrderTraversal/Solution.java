package com.lyx.leetcode.Tree.binaryTreeLevelOrderTraversal;

import com.lyx.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyx on 2018/4/23.
 */
public class Solution {
    public List<List<Integer>> levelOrderBottem(TreeNode root) {
        List<Integer> levelList = new ArrayList<Integer>();
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null) return resultList;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                levelList.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            } else {
                resultList.add(0, levelList);//和I相比只有这里不同
                if (!queue.isEmpty()) {
                    levelList = new ArrayList<Integer>();
                    queue.add(null);
                }
            }
        }
        return resultList;
    }

}
