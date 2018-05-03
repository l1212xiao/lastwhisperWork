package com.lyx.Tree.binaryTreeLevelOrderTraversal;

import com.lyx.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lyx on 2018/4/23.
 */
public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> levelList = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return resultList;
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode != null) {
                levelList.add(curNode.val);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            } else {
                resultList.add(levelList);
                if (!queue.isEmpty()) {
                    levelList = new ArrayList<Integer>();
                    queue.add(null);
                }
            }
        }
        return resultList;
    }
}
