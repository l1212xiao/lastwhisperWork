package com.lyx.Tree.binaryTreeInorderTraversal;

import com.lyx.Tree.TreeNode;

import java.util.ArrayList;

/**
 * Created by lyx on 2018/5/3.
 * 递归实现
 */
class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        traversal(root,list);
        return list;
    }
    public void traversal(TreeNode root,ArrayList<Integer> list){
        if(root == null) return;
        traversal(root.left,list);
        list.add(root.val);
        traversal(root.right,list);
    }
}
