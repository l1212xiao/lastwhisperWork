package com.lyx.everyDayTraining.beforeMeituan.populatingNextRightPointersInEachNodeII;

/*
117. 填充每个节点的下一个右侧节点指针 II
给定一个二叉树

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

进阶：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

示例：

输入：root = [1,2,3,4,5,null,7]
输出：[1,#,2,3,#,4,5,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
提示：
树中的节点数小于 6000
-100 <= node.val <= 100
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @date 2020/9/28
 */


class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // node -> 层数
        Map<Node, Integer> levelMap = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        stack.push(cur);
        levelMap.put(cur, 1);
        // 先序遍历，记录遍历顺序
        List<Node> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node);
            if (node.right != null) {
                stack.push(node.right);
                levelMap.put(node.right, levelMap.get(node) + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                levelMap.put(node.left, levelMap.get(node) + 1);
            }
        }
        // 查看是否遍历过，如果出现过，则连接next
        Map<Integer, Node> recordMap = new HashMap<>();
        for (Node node : list) {
            int l = levelMap.get(node);
            if (recordMap.containsKey(l)) {
                Node preNode = recordMap.get(l);
                preNode.next = node;
            }
            recordMap.put(l, node);
        }
        return root;
    }
}

    /*
    方法一：层次遍历
    思路与算法

    这道题希望我们把二叉树各个层的点组织成链表，一个非常直观的思路是层次遍历。
    树的层次遍历基于广度优先搜索，它按照层的顺序遍历二叉树，在遍历第 ii 层前，一定会遍历完第 i - 1i−1 层。
    这样做可以保证每次遍历的 nn 个点都是同一层的。我们可以在遍历每一层的时候修改这一层节点的 next 指针，
    这样就可以把每一层都组织成链表。

    链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-15/
     */


class Solution2 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; i++) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 1) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
