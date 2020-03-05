package com.lyx.lagouLearning.demo03_sort;

/**
 * @author lvyunxiao
 * @classname TopologicalSort
 * @description TopologicalSort
 * @date 2019/12/25
 */
public class TopologicalSort {

    // public void sort() {
    //     Queue<Integer> q = new LinkedList(); // 定义一个队列 q
    //
    //     // 将所有入度为 0 的顶点加入到队列 q
    //     for (int v = 0; v < V; v++) {
    //         if (indegree[v] == 0) q.add(v);
    //     }
    //
    //     // 循环，直到队列为空
    //     while (!q.isEmpty()) {
    //         int v = q.poll();
    //         // 每次循环中，从队列中取出顶点，即为按照入度数目排序中最小的那个顶点
    //         print(v);
    //
    //         // 将跟这个顶点相连的其他顶点的入度减 1，如果发现那个顶点的入度变成了 0，将其加入到队列的末尾
    //         for (int u = 0; u < adj[v].length; u++) {
    //             if (--indegree[u] == 0) {
    //                 q.add(u);
    //             }
    //         }
    //     }
    // }

}
