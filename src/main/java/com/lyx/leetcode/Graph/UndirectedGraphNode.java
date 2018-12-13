package com.lyx.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyx on 2018/5/30.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
