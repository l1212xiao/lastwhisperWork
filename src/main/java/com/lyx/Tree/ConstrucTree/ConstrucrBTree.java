package com.lyx.Tree.ConstrucTree;

import com.lyx.Tree.TreeNode;

import java.util.Arrays;

/**
 * Created by lyx on 2018/9/21
 * 根据中序和前序序列生成二叉树java递归实现
 * <p>
 * Arrays.copyOfRange(T[ ] original,int from,int to)
 * 将一个原始的数组original，从小标from开始复制，复制到小标to，生成一个新的数组。
 * 注意这里包括下标from，不包括上标to
 * <p>
 * 本文来自 babylorin 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/babylorin/article/details/67637454?utm_source=copy
 * 参考 ：https://blog.csdn.net/wlittlefive/article/details/80463657
 */
public class ConstrucrBTree {


    public static TreeNode buildTree(int[] preOrders, int[] inOrders) {

        if (preOrders.length == 0 || inOrders.length == 0) {
            return null;
        }

        int[] newPreOrders, newInOrders;
        TreeNode treeNode = new TreeNode(preOrders[0]);
        int index = search(0, inOrders.length, inOrders, treeNode.val);

        newPreOrders = Arrays.copyOfRange(preOrders, 1, index + 1);
        newInOrders = Arrays.copyOfRange(inOrders, 0, index);
        treeNode.left = buildTree(newPreOrders, newInOrders);

        newPreOrders = Arrays.copyOfRange(preOrders, index + 1, preOrders.length);
        newInOrders = Arrays.copyOfRange(inOrders, index + 1, inOrders.length);
        treeNode.right = buildTree(newPreOrders, newInOrders);

        return treeNode;
    }

    //从中序找出跟所在位置
    public static int search(int start, int end, int[] inOrders, int data) {
        for (int i = start; i < end; i++) {
            if (data == inOrders[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] preOrders = new int[]{1, 2, 4, 8, 5, 3, 6, 7};
        int[] inOrders = new int[]{8, 4, 2, 5, 1, 6, 3, 7};
        buildTree(preOrders, inOrders);

    }

}
