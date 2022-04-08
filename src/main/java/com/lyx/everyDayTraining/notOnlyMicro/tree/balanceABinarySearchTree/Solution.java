package com.lyx.everyDayTraining.notOnlyMicro.tree.balanceABinarySearchTree;

/*
1382. 将二叉搜索树变平衡

给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。

示例 1：

输入：root = [1,null,2,null,3,null,4,null,null]
输出：[2,1,3,null,null,null,4]
解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。

示例 2：

输入: root = [2,1,3]
输出: [2,1,3]

提示：
    树节点的数目在 [1, 10^4] 范围内。
    1 <= Node.val <= 10^5
 */


import com.lyx.everyDayTraining.notOnlyMicro.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/3/28
 * @description
 */
public class Solution {

    List<Integer> inorderSeq = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        getInorder(root);
        return build(0, inorderSeq.size() - 1);
    }

    public void getInorder(TreeNode root) {
        if (root != null) {
            getInorder(root.left);
            inorderSeq.add(root.val);
            getInorder(root.right);
        }
    }

    public TreeNode build(int l, int r) {
        int mid = (l + r) >> 1;
        TreeNode root = new TreeNode(inorderSeq.get(mid));
        if (l <= mid - 1) {
            root.left = build(l, mid - 1);
        }
        if (mid + 1 <= r) {
            root.right = build(mid + 1, r);
        }
        return root;
    }

}
