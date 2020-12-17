package com.lyx.everyDayTraining.beforeMeituan.minimumAbsoluteDifferenceInBst;

/*
530. 二叉搜索树的最小绝对差
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

示例：
输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */


import com.lyx.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @date 2020/10/12
 */
public class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        int ans = Integer.MAX_VALUE;
        getInder(root, order);
        for (int i = 1; i < order.size(); i++) {
            ans = Math.min(ans, order.get(i) - order.get(i - 1));
        }
        return ans;
    }

    public void getInder(TreeNode root, List<Integer> order) {
        if (root != null) {
            getInder(root.left, order);
            order.add(root.val);
            getInder(root.right, order);
        }
    }

    public int getMinimumDifference2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer pre = null;
        int ans = Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (pre != null) {
                    ans = Math.min(ans, node.val - pre);
                }
                pre = node.val;
                root = node.right;
            }
        }
        return ans;
    }
}
