package com.lyx.everyDayTraining.beforeMeituan.sumOfDistancesInTree;

/*
834. 树中距离之和
给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
返回一个表示节点 i 与其他所有节点距离之和的列表 ans。

示例 1:

输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
输出: [8,12,6,10,10,10]
解释:
如下为给定的树的示意图：
  0
 / \
1   2
   /|\
  3 4 5

我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
说明: 1 <= N <= 10000
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lvyunxiao
 * @date 2020/10/6
 */
public class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] ans = new int[N];
        if (N == 0 || edges == null || edges.length == 0) {
            return ans;
        }
        int distance;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (map.containsKey(edge[0])) {
                map.get(edge[0]).add(edge[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edge[1]);
                map.put(edge[0], set);
            }
            if (map.containsKey(edge[1])) {
                map.get(edge[1]).add(edge[0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edge[0]);
                map.put(edge[1], set);
            }
        }

        // dp[i][j] 表示i -> j的距离
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            distance = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                Set<Integer> path = new HashSet<>();
                int d;
                if (dp[i][j] != 0) {
                    d = dp[i][j];
                } else {
                    d = getDistance(i, j, map, path, Integer.MAX_VALUE / 2, dp);
                    dp[i][j] = d;
                }
                // System.out.println(i + "->" + j + " d: " + d);
                distance += d;
                // distance += getDistance(i, j, map, path);
            }
            // System.out.println("==================");
            ans[i] = distance;
        }
        return ans;
    }

    public int getDistance(int i, int j, Map<Integer, Set<Integer>> map, Set<Integer> path, int pre, int[][] dp) {
        int distance = pre;
        path.add(i);
        if (map.get(i).contains(j)) {
            return 1;
        } else {
            Set<Integer> set = map.get(i);
            for (int x : set) {
                if (path.contains(x)) {
                    continue;
                }
                if (dp[x][j] != 0) {
                    distance = dp[x][j];
                } else {
                    distance = Math.min(distance, getDistance(x, j, map, path, distance, dp) + 1);
                    dp[x][j] = distance;
                }
                // System.out.println("x: " + x + " j: " + j + " d: " + distance);
            }
            return distance;
        }
    }

    public static void main(String[] args) {
        // 输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
        // 输出: [8,12,6,10,10,10]
        Solution s = new Solution();
        int N = 6;
        int[][] edges = {
                {0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}
        };
        int[] arr = s.sumOfDistancesInTree(N, edges);
        System.out.println(Arrays.toString(arr));
    }
}
