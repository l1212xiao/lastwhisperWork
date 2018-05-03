package com.lyx.Tree.sameTree;

import com.lyx.Tree.TreeNode;

/**
 * Created by lyx on 2018/4/16.
 */
public class Test {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode pl = new TreeNode(2);
        p.left = pl;

        TreeNode q = new TreeNode(1);
        TreeNode ql = new TreeNode(2);
        q.left = ql;
        
        Solution solution = new Solution();
        boolean sameTree = solution.isSameTree(p, q);

        System.out.println(sameTree);
    }
}
