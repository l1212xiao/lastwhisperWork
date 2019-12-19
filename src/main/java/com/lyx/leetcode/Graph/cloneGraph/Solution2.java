package com.lyx.leetcode.Graph.cloneGraph;

import com.lyx.leetcode.Graph.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by lyx on 2018/5/30.
 * 133. Clone Graph
 */
public class Solution2 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node, cloneNode);

        stack.push(node);
        while (!stack.isEmpty()) {
            UndirectedGraphNode curNode = stack.pop();

            for (int i = 0; i < curNode.neighbors.size(); i++) {
                if (!map.containsKey(curNode.neighbors.get(i))) {
                    cloneNode = new UndirectedGraphNode(curNode.neighbors.get(i).label);
                    map.put(curNode.neighbors.get(i), cloneNode);

                    stack.push(curNode.neighbors.get(i));
                }
                map.get(curNode).neighbors.add(map.get(curNode.neighbors.get(i)));
            }
        }
        return map.get(node);
    }
}
