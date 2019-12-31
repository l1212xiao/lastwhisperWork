package com.lyx.lagouLearning.demo02_advanced.Graph;

import java.util.List;

/**
 * @author lvyunxiao
 * @classname Node
 * @description Node
 * @date 2019/12/13
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        this.val = _val;
        this.neighbors = _neighbors;
    }

}
