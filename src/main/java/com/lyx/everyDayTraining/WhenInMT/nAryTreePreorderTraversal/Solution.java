package com.lyx.everyDayTraining.WhenInMT.nAryTreePreorderTraversal;

/*
589. N 叉树的前序遍历

给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。

示例 1：

输入：root = [1,null,3,2,4,null,5,6]
输出：[1,3,5,6,2,4]

示例 2：

输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]



提示：

    节点总数在范围 [0, 104]内
    0 <= Node.val <= 104
    n 叉树的高度小于或等于 1000

 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author lvyunxiao
 * @date 2022/3/10
 * @description
 */
public class Solution {

    List<Integer> ans = new ArrayList<>();

    /*
    递归
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        if (root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return ans;
    }

    /*
    非递归
     */
    public List<Integer> preorder2(Node root) {
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return ans;
    }

    /*
    类似题，层序遍历
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                Node node = queue.poll();
                curLevel.add(node.val);
                queue.addAll(node.children);
            }
            res.add(curLevel);
        }
        return res;
    }


    class Node {

        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
