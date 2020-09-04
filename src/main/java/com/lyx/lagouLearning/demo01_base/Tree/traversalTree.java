package com.lyx.lagouLearning.demo01_base.Tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname traversalTree
 * @description traversalTree
 * @date 2019/12/7
 */
public class traversalTree {

    /**
     * 构造二叉树
     */
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历，递归实现
     */
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 二叉树遍历结果需要存入List<Integer>中,递归方式
     */
    class Solution {

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            while (root != null) {
                res.add(root.val);
                helper(root.left, res);
                helper(root.right, res);
            }
        }
    }

    /**
     * 二叉树遍历结果需要存入List<Integer>中,非递归方式
     */
    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> res = new ArrayList<>();
            if (root != null) {
                stack.push(root);
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return res;
        }
    }

    /**
     * 前序遍历，非递归实现
     * 1. 先入栈根节点，输出根节点val值，再先后入栈其右节点、左结点；
     * 2. 出栈左节点，输出其val值，再入栈该左节点的右节点、左节点；直到遍历完该左节点所在子树。
     * 3. 再出栈右节点，输出其val值，再入栈该右节点的右节点、左节点；直到遍历完该右节点所在子树。
     */
    public void preOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val);
            //右结点先入栈，左结点后入栈
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历，递归实现
     */
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val);
            inOrder(root.right);
        }
    }

    /**
     * 中序遍历，非递归实现
     *  1. 首先从根节点出发一路向左，入栈所有的左节点；
     *  2. 出栈一个节点，输出该节点val值，查询该节点是否存在右节点，
     *     若存在则从该右节点出发一路向左入栈该右节点所在子树所有的左节点；
     *  3. 若不存在右节点，则出栈下一个节点，输出节点val值，同步骤2操作；
     *  4. 直到节点为null，且栈为空。
     */
    public void inOrder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.print(node.val);
                root = node.right;
            }
        }
    }

    /**
     * 后序遍历，递归实现
     */
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val);
        }
    }

    /**
     * 后序遍历，非递归实现
     *  后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树
     *  若是位于左子树，则需要跳过根节点，先进入右子树，再回头访问跟节点
     *  若是位于右子树，则直接访问根节点
     */
    public static void postOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        //移到最左边
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        while (!stack.empty()) {
            cur = stack.pop();

            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (cur.right != null && cur.right != pre) {
                stack.push(cur);
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            } else {
                System.out.print(cur.val + " ");
                pre = cur;
            }
        }
    }

    public static void postOrder2(TreeNode root) {
        System.out.print("pos-order: ");
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode c;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && root != c.left && root != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && root != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().val + " ");
                    root = c;
                }
            }
        }
        System.out.println();
    }

    /**
     * 层序遍历（广度优先遍历）
     */
    public void layerOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 得到二叉树的镜像
     */
    public void getMirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            getMirror(root.left);
            getMirror(root.right);
        }
    }

    /**
     * 判断一颗二叉树是不是对称，注意，如果一个二叉树和它的镜像是一样的，那么它是对称的。
     * 分析：
     * 对于一棵二叉树，从根结点开始遍历，
     * 如果左右子结点有一个为NULL，那么肯定不是对称二叉树；
     * 如果左右子结点均不为空，但不相等，那么肯定不是对称二叉树；
     * 如果左右子结点均不为空且相等，那么
     * 遍历左子树，遍历顺序为：当前结点，左子树，右子树；
     * 遍历右子树，遍历顺序为：当前结点，右子树，左子树；
     * 如果遍历左子树的序列和遍历右子树的序列一样，那么该二叉树为对称的二叉树。（递归实现）
     * 原文链接：https://blog.csdn.net/weixin_37672169/article/details/80204565
     */

    /**
     * 对称的二叉树
     */
    public class SymmetricalBinaryTree {

        public boolean isSymmetrical(TreeNode root) {
            return isSymmetrical(root, root);
        }

        public boolean isSymmetrical(TreeNode root1, TreeNode root2) {
            //如果两个根节点都是null
            if (root1 == null && root2 == null) {
                return true;
            }

            //如果只有一个根节点是null
            if (root1 == null || root2 == null) {
                return false;
            }

            /**
             * 两个根节点都不为null
             */
            if (root1.val != root2.val) {
                return false;
            }

            return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
        }

    }

    /**
     * 1
     * /   \
     * 2     3
     * /  \  /  \
     * 4   5 6    7
     */
    @Test
    public void testTraversal() {
       TreeNode node1 = new TreeNode(1);
       TreeNode node2 = new TreeNode(2);
       TreeNode node3 = new TreeNode(3);
       TreeNode node4 = new TreeNode(4);
       TreeNode node5 = new TreeNode(5);
       TreeNode node6 = new TreeNode(6);
       TreeNode node7 = new TreeNode(7);

       node1.left = node2;
       node1.right = node3;

       node2.left = node4;
       node2.right = node5;

       node3.left = node6;
       node3.right = node7;

        // TreeNode node1 = new TreeNode(3);
        // TreeNode node2 = new TreeNode(1);
        // TreeNode node3 = new TreeNode(4);
        // TreeNode node4 = new TreeNode(2);
        // TreeNode node5 = new TreeNode(1);
        //
        // node1.left = node2;
        // node1.right = node3;
        //
        // node2.right = node4;
        //
        // node3.left = node5;

        inOrder1(node1);
        System.out.println();
    }
}
