package com.lyx.geek.AlgoMei.treenode;

/*
449. 序列化和反序列化二叉搜索树

序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。
您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。

编码的字符串应尽可能紧凑。

示例 1：

输入：root = [2,1,3]
输出：[2,1,3]

示例 2：

输入：root = []
输出：[]

 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author lvyunxiao
 * @date 2021/8/24
 * @description
 */
public class SerializeAndDeserializeBst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.right = node3;
        CodecOwn codec = new CodecOwn();
        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize.val);
    }
}

// 作者：Booooo_
//     链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst/solution/xu-lie-hua-he-fan-xu-lie-hua-er-cha-sou-0fq67/
//     来源：力扣（LeetCode）
//     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

/**
 * [LC.449]. 序列化和反序列化二叉搜索树
 */
class CodecOwn {

    String SEP = ",";
    String NULL = "#";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SEP)));
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}


class CodecOrg {

    public StringBuilder postorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb;
        }
        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(root.val);
        // sb.append(' ');
        sb.append(',');
        return sb;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = postorder(root, new StringBuilder());
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
        if (nums.isEmpty()) {
            return null;
        }
        int val = nums.getLast();
        if (val < lower || val > upper) {
            return null;
        }

        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, upper, nums);
        root.left = helper(lower, val, nums);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        // for (String s : data.split("\\s+")) {
        for (String s : data.split(",")) {
            nums.add(Integer.valueOf(s));
        }
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }
}

// 作者：LeetCode
//     链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst/solution/xu-lie-hua-he-fan-xu-lie-hua-er-cha-sou-suo-shu-2/
//     来源：力扣（LeetCode）
//     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
