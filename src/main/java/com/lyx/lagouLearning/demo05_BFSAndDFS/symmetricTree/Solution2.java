package com.lyx.lagouLearning.demo05_BFSAndDFS.symmetricTree;

import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lvyunxiao
 * @classname Solution2
 * @description Solution2
 * @date 2020/1/21
 *
 * 方法二：迭代
 * 除了递归的方法外，我们也可以利用队列进行迭代。
 * 队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。
 * 最初，队列中包含的是 root 以及 root。该算法的工作原理类似于 BFS，
 * 但存在一些关键差异。每次提取两个结点并比较它们的值。
 * 然后，将两个结点的左右子结点按相反的顺序插入队列中。
 * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode/
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}
