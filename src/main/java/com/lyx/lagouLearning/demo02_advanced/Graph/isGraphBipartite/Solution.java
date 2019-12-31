package com.lyx.lagouLearning.demo02_advanced.Graph.isGraphBipartite;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/14
 */
public class Solution {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei : graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; ++i) {
            if (color[i] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                color[i] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei : graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = new int[4][];
        graph[0] = new int[]{1, 3};
        graph[1] = new int[]{0, 2};
        graph[2] = new int[]{1, 3};
        graph[3] = new int[]{0, 2};

        Solution solution = new Solution();
        final boolean bipartite = solution.isBipartite(graph);
        System.out.println(bipartite);
    }

}
