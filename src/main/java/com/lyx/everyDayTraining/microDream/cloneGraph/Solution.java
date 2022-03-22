package com.lyx.everyDayTraining.microDream.cloneGraph;

/*
133. 克隆图

给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
class Node {
    public int val;
    public List<Node> neighbors;
}

测试用例格式：
简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），
以此类推。该图在测试用例中使用邻接列表表示。
邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。

示例 1：

输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
输出：[[2,4],[1,3],[2,4],[1,3]]
解释：
图中有 4 个节点。
节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
节点 4 的值是 4，它有两个邻居：节点 1 和 3 。

示例 2：

输入：adjList = [[]]
输出：[[]]
解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。

示例 3：

输入：adjList = []
输出：[]
解释：这个图是空的，它不含任何节点。

示例 4：

输入：adjList = [[2],[1]]
输出：[[2],[1]]

提示：

    节点数不超过 100 。
    每个节点值 Node.val 都是唯一的，1 <= Node.val <= 100。
    无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
    由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
    图是连通图，你可以从给定节点访问到所有节点。
 */


import com.lyx.utils.FastJsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * @author lvyunxiao
 * @date 2022/3/3
 * @description
 */
public class Solution {

    public static class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

        @Override
        public String toString() {
            return "Node{" +
                "val=" + val +
                ", neighbors=" + FastJsonUtils.toJSONStr(neighbors) +
                '}';
        }

    }

    /*
    广度优先遍历
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node cur = node;
        queue.offer(cur);
        map.put(cur, new Node(cur.val));
        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node cur = node;
        queue.offer(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            map.put(cur, new Node(cur.val));
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        map.forEach(
            (src, des) -> {
                List<Node> neighbors = src.neighbors;
                List<Node> newNeighbors = new ArrayList<>();
                for (Node neighbor : neighbors) {
                    newNeighbors.add(map.get(neighbor));
                }
                map.get(src).neighbors = newNeighbors;
            }
        );
        return map.get(node);
    }

    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraphOrg1(Node node) {
        if (node == null) {
            return node;
        }

        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        Node cloneNode = new Node(node.val, new ArrayList());
        // 哈希表存储
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraphOrg1(neighbor));
        }
        return cloneNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        List<Node> neighbors1 = new ArrayList<>();
        neighbors1.add(node2);
        neighbors1.add(node4);
        node1.neighbors = neighbors1;

        List<Node> neighbors2 = new ArrayList<>();
        neighbors2.add(node1);
        neighbors2.add(node3);
        node2.neighbors = neighbors2;

        List<Node> neighbors3 = new ArrayList<>();
        neighbors3.add(node2);
        neighbors3.add(node4);
        node3.neighbors = neighbors3;

        List<Node> neighbors4 = new ArrayList<>();
        neighbors4.add(node1);
        neighbors4.add(node3);
        node4.neighbors = neighbors4;

        Solution s = new Solution();
        Node node = s.cloneGraph(node1);
        System.out.println(node);
    }


}
