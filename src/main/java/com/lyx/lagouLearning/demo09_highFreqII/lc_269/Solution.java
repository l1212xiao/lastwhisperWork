package com.lyx.lagouLearning.demo09_highFreqII.lc_269;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/20
 * <p>
 * ref:https://kaiwu.lagou.com/course/courseInfo.htm?courseId=3#/detail/pc?id=37
 * <p>
 * 269.火星字典
 * LeetCode第269题，火星字典：现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
 * 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个不为空的单词列表。
 * 因为是从词典中获得的，所以该单词列表内的单词已经按这门新语言的字母顺序进行了排序。
 * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
 * <p>
 * 示例 1 输入:["wrt","wrf","er","ett","rftt"] 输出:"wertf"
 * 示例 2 输入:["z","x"]输出:"zx"
 * 示例 3 输入:[ "z","x","z"] 输出: "" 解释: 此顺序是非法的，因此返回 ""。
 * 解题思路
 * 首先，确定字符串排序方法。
 * 理解题意，关键是搞清楚给定的输入字符串是怎么排序的？
 * 解法：
 * 1.逐位地比较两个相邻的字符串
 * 2.第一个字母出现的顺序越早，排位越靠前
 * 3.第一个字母相同时，比较第二字母，以此类推
 * 注意：两个字符串某个相同的位置出现了不同，就立即能得出它们的顺序，无需继续比较字符串剩余字母。
 * <p>
 * 包括两大步骤，第一步是根据输入构建一个有向图；第二步是对这个有向图进行拓扑排序。
 */
public class Solution {

    // 基本情况处理，比如输入为空，或者输入的字符串只有一个
    String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        if (words.length == 1) {
            return words[0];
        }
        //构建有向图:定义一个邻接链表adjList, 也可以用邻接矩阵
        Map<Character, List<Character>> adjList = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int n1 = w1.length(), n2 = w2.length();
            boolean found = false;

            for (int j = 0; j < Math.max(w1.length(), w2.length()); j++) {
                Character c1 = j < n1 ? w1.charAt(j) : null;
                Character c2 = j < n2 ? w2.charAt(j) : null;
                if (c1 != null && !adjList.containsKey(c1)) {
                    adjList.put(c1, new ArrayList<Character>());
                }
                if (c2 != null && !adjList.containsKey(c2)) {
                    adjList.put(c2, new ArrayList<Character>());
                }
                if (c1 != null && c2 != null && c1 != c2 && !found) {
                    adjList.get(c1).add(c2);
                    found = true;
                }
            }
        }
        Set<Character> visited = new HashSet<>();
        Set<Character> loop = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (Character key : adjList.keySet()) {
            if (!visited.contains(key)) {
                if (!topologicalSort(adjList, key, visited, loop, stack)) {
                    return "";
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    // 将当前节点 u 加入到 visited 集合以及 loop 集合中。
    public boolean topologicalSort(Map<Character, List<Character>> adjList, char u,
                                   Set<Character> visited, Set<Character> loop, Stack<Character> stack) {
        visited.add(u);
        loop.add(u);
        if (adjList.containsKey(u)) {
            for (int i = 0; i < adjList.get(u).size(); i++) {
                char v = adjList.get(u).get(i);
                if (loop.contains(v)) {
                    return false;
                }
                if (!visited.contains(v)) {
                    if (!topologicalSort(adjList, v, visited, loop, stack)) {
                        return false;
                    }
                }
            }
        }
        loop.remove(u);
        stack.push(u);
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        Solution solution = new Solution();
        String s = solution.alienOrder(words);
        System.out.println(s); // wertf
    }
}
