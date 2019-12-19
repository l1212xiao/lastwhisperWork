package com.lyx.leetcode.Graph.cloneGraph;

import com.lyx.leetcode.Graph.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by lyx on 2018/5/30.
 * 133. Clone Graph
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node, cloneNode);

        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();

            for (int i = 0; i < curNode.neighbors.size(); i++) {
                if (!map.containsKey(curNode.neighbors.get(i))) {
                    cloneNode = new UndirectedGraphNode(curNode.neighbors.get(i).label);
                    map.put(curNode.neighbors.get(i), cloneNode);

                    queue.offer(curNode.neighbors.get(i));
                }
                //把克隆节点的neighbors添加进来
                map.get(curNode).neighbors.add(map.get(curNode.neighbors.get(i)));
            }
        }
        return map.get(node);
    }
}
