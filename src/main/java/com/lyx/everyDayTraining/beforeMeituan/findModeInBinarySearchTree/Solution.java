package com.lyx.everyDayTraining.beforeMeituan.findModeInBinarySearchTree;

/*
501. 二叉搜索树中的众数
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

提示：如果众数超过1个，不需考虑输出顺序
进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */


import com.lyx.leetcode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvyunxiao
 * @date 2020/9/24
 */
public class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : list) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                ans.clear();
                ans.add(num);
            } else if (count == maxCount) {
                ans.add(num);
            }
        }
        int[] ansArr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }

    public void inOrder(List<Integer> list, TreeNode root) {
        if (root != null) {
            inOrder(list, root.left);
            list.add(root.val);
            inOrder(list, root.right);
        }
    }

    public static void main(String[] args) {

    }
}
