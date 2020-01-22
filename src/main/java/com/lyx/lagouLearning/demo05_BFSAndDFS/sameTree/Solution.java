package com.lyx.lagouLearning.demo05_BFSAndDFS.sameTree;

import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/1/21
 * <p>
 * leetcode
 * 100. 相同的树
 * 最简单的策略是使用递归。首先判断 p 和 q 是不是 None，然后判断它们的值是否相等。
 * 若以上判断通过，则递归对子结点做同样操作。
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
