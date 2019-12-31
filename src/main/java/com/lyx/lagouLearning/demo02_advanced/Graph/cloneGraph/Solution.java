package com.lyx.lagouLearning.demo02_advanced.Graph.cloneGraph;

import com.lyx.lagouLearning.demo02_advanced.Graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/13
 */
public class Solution {
    // 广度优先遍历进行复制
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // 造出一个队列和map用于存储Node
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();

        // 复制出源节点，类似树的根节点，并入队
        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.put(node, cloneNode);

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            // 遍历源节点的相邻节点，复制并入队
            for (Node neighbor : curNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                // 把克隆节点的相邻节点添加进来
                map.get(curNode).neighbors.add(map.get(neighbor));
            }
        }
        return cloneNode;
    }

    // 深度优先遍历进行复制
    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Map<Node, Node> map = new HashMap<>();

        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.put(node, cloneNode);

        stack.push(node);
        while (!stack.isEmpty()) {
            Node curNode = stack.pop();
            for (Node neighbor : curNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    stack.push(neighbor);
                }
                map.get(curNode).neighbors.add(map.get(neighbor));
            }
        }
        return cloneNode;
    }

}
