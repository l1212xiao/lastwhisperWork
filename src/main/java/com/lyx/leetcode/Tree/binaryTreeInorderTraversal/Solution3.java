package com.lyx.Tree.binaryTreeInorderTraversal;

import com.lyx.Tree.TreeNode;

import java.util.ArrayList;

/**
 * Created by lyx on 2018/5/4.
 */
public class Solution3 {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left == null) {
                list.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return list;
    }
}
