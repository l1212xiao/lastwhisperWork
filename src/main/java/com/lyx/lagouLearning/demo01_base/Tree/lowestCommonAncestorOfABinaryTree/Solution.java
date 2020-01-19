package com.lyx.lagouLearning.demo01_base.Tree.lowestCommonAncestorOfABinaryTree;

import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/20
 * <p>
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 解题思路：
 * <p>
 * 递归搜索左右子树，如果左子树和右子树都不为空，说明最近父节点一定在根节点。
 * 反之，如果左子树为空，说明两个节点一定在右子树；
 * 同理如果右子树为空，说明两个节点一定在左子树。
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;
    }

    /**
     * 从根节点开始遍历树。
     * 在找到 p 和 q 之前，将父指针存储在字典中。
     * 一旦我们找到了 p 和 q，我们就可以使用父亲字典获得 p 的所有祖先，并添加到一个称为祖先的集合中。
     * 同样，我们遍历节点 q 的祖先。如果祖先存在于为 p 设置的祖先中，这意味着这是 p 和 q 之间的第一个共同祖先（同时向上遍历），因此这是 LCA 节点。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetcod/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // Stack<TreeNode> stack1 = new Stack<>();
        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

}
