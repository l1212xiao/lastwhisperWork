package com.lyx.lagouLearning.demo05_BFSAndDFS.sameTree;

import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;

import java.util.ArrayDeque;

/**
 * @author lvyunxiao
 * @classname Solution2
 * @description Solution2
 * @date 2020/1/21
 * <p>
 * 方法二：迭代
 * 直觉
 * 从根开始，每次迭代将当前结点从双向队列中弹出。然后，进行方法一中的判断：
 * p 和 q 不是 None,
 * p.val 等于 q.val,
 * 若以上均满足，则压入子结点。
 */
class Solution2 {
    public boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q)) return false;
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)) return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }
}

