package com.lyx.geek.AlgoMei.treenode;

/*
297. 二叉树的序列化与反序列化
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

示例 1：

输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]

示例 2：

输入：root = []
输出：[]

示例 3：

输入：root = [1]
输出：[1]

示例 4：

输入：root = [1,2]
输出：[1,2]

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2021/8/26
 * @description
 */
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        Codec codec = new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize.val);
    }

}

/*
[LC.297]. 二叉树的序列化与反序列化
 */
class Codec {

    public static final String SPE = ",";
    public static final String NIL = "#";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NIL).append(SPE);
            return;
        }
        sb.append(root.val).append(SPE);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(SPE);
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return deserialize(dataList);
    }

    public TreeNode deserialize(List<String> dataList) {
        if (dataList.get(0).equals(NIL)) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = deserialize(dataList);
        root.right = deserialize(dataList);

        return root;
    }
}

// 作者：LeetCode-Solution
//     链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/er-cha-shu-de-xu-lie-hua-yu-fan-xu-lie-hua-by-le-2/
//     来源：力扣（LeetCode）
//     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
