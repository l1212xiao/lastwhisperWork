package com.lyx.lagouLearning.demo05_BFSAndDFS.maximumDepthOfBinaryTree;

import com.lyx.lagouLearning.demo01_base.Tree.TreeNode;
import javafx.util.Pair;

import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution2
 * @description Solution2
 * @date 2020/1/21
 *
 * 方法二：迭代
 * 我们还可以在栈的帮助下将上面的递归转换为迭代。
 *
 * 我们的想法是使用 DFS 策略访问每个结点，同时在每次访问时更新最大深度。
 * 所以我们从包含根结点且相应深度为 1 的栈开始。然后我们继续迭代：将当前结点弹出栈并推入子结点。每一步都会更新深度。
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        if (root != null) {
            stack.push(new Pair<>(root, 1));
        }
        stack.push(new Pair<>(root, 1));

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            root = cur.getKey();
            int curDepth = cur.getValue();
            if (root != null) {
                depth = Math.max(curDepth, depth);
                stack.push(new Pair<>(root.left, curDepth + 1));
                stack.push(new Pair<>(root.right, curDepth + 1));
            }
        }
        return depth;
    }
}
