package com.lyx.everyDayTraining.pathSumII;

/*
113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */


import com.lyx.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, sum, ans, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, int rest, List<List<Integer>> ans, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        rest -= root.val;
        if (root.left == null && root.right == null && rest == 0) {
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left, rest, ans, path);
        dfs(root.right, rest, ans, path);
        path.remove(path.size() - 1);
    }

    // List<List<Integer>> ans = new LinkedList<>();
    // Deque<Integer> path = new LinkedList<>();
    //
    // public List<List<Integer>> pathSum(TreeNode root, int sum) {
    //     dfs(root, sum);
    //     return ans;
    // }
    //
    // public void dfs(TreeNode root, int sum) {
    //     if (root == null) {
    //         return;
    //     }
    //     path.offerLast(root.val);
    //     sum -= root.val;
    //     if (root.left == null && root.right == null && sum == 0) {
    //         ans.add(new LinkedList<>(path));
    //     }
    //     dfs(root.left, sum);
    //     dfs(root.right, sum);
    //     path.pollLast();
    // }

    // 作者：LeetCode-Solution
    // 链接：https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
