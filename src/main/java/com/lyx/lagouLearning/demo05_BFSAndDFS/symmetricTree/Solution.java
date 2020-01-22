package com.lyx.lagouLearning.demo05_BFSAndDFS.symmetricTree;

import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/1/21
 *
 * 101. 对称二叉树
 * 如果一个树的左子树与右子树镜像对称，那么这个树是对称的。
 *
 * 因此，该问题可以转化为：两个树在什么情况下互为镜像？
 *
 * 如果同时满足下面的条件，两个树互为镜像：
 *
 * 它们的两个根结点具有相同的值。
 * 每个树的右子树都与另一个树的左子树镜像对称。。
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
