package com.lyx.everyDayTraining.microDream.maximumLengthOfAConcatenatedStringWithUniqueCharacters;

/*
1239. 串联字符串的最大长度
给定一个字符串数组 arr，字符串 s 是将 arr 的含有 不同字母 的 子序列 字符串 连接 所得的字符串。
请返回所有可行解 s 中最长长度。
子序列 是一种可以从另一个数组派生而来的数组，通过删除某些元素或不删除元素而不改变其余元素的顺序。

示例 1：

输入：arr = ["un","iq","ue"]
输出：4
解释：所有可能的串联组合是：
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
最大长度为 4。

示例 2：

输入：arr = ["cha","r","act","ers"]
输出：6
解释：可能的解答有 "chaers" 和 "acters"。

示例 3：

输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
输出：26

提示：
    1 <= arr.length <= 16
    1 <= arr[i].length <= 26
    arr[i] 中只含有小写英文字母
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/4/19
 * @description
 */
public class Solution {

    public int maxLength(List<String> arr) {
        int maxLength = 0;
        List<List<Character>> ansList = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        dfs(arr, ansList, path, 0);
        for (List<Character> list : ansList) {
            maxLength = Math.max(maxLength, list.size());
        }
        return maxLength;
    }

    private void dfs(List<String> arr, List<List<Character>> ansList, List<Character> path, int curIdx) {
        if (curIdx == arr.size()) {
            ansList.add(new ArrayList<>(path));
            return;
        }
        // 选择第curIdx个
        String a = arr.get(curIdx);
        if (canChoose(path, a)) {
            for (int i = 0; i < a.length(); i++) {
                path.add(a.charAt(i));
            }
            dfs(arr, ansList, path, curIdx + 1);

            for (int i = 0; i < a.length(); i++) {
                path.remove(path.size() - 1);
            }
            dfs(arr, ansList, path, curIdx + 1);
        } else {
            dfs(arr, ansList, path, curIdx + 1);
        }
    }

    private boolean canChoose(List<Character> path, String a) {
        List<Character> list = new ArrayList<>(path);
        for (int i = 0; i < a.length(); i++) {
            if (list.contains(a.charAt(i))) {
                return false;
            } else {
                list.add(a.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> arr = new ArrayList<String>() {{
            add("un");
            add("iq");
            add("ue");
        }};

        String[] strArr = {"un", "iq", "ue"};
        // List<String> list = Arrays.asList(strArr);
        List<String> list = Arrays.asList("un", "iq", "ue");

        // List<String> arr = new ArrayList<String>(){{
        //     add("aa");
        //     add("bb");
        // }};
        // int maxLength = s.maxLength(arr);
        int maxLength = s.maxLength(list);
        System.out.println(maxLength);
    }


    /* 方法一：回溯 + 位运算

    我们需要计算可行解的长度，至于可行解具体是什么，以及可行解中各个字符的顺序我们是不用考虑的。
    因此构成可行解的每个字符串均可以视作一个字符集合，且集合不含重复元素。
    由于构成可行解的字符串仅包含小写字母，且无重复元素，我们可以用一个二进制数来表示该字符串的字符集合，
    二进制的第 i 位为 1 表示字符集合中含有第 i 个小写字母，为 0 表示字符集合中不含有第 i 个小写字母。

    由于包含重复字母的字符串无法参与构成可行解，因此遍历 arr，从中筛选出无重复字母的字符串，将其对应二进制数加入一数组，记作 masks。
    */
    class SolutionOrg {
        int ans = 0;

        public int maxLength(List<String> arr) {
            List<Integer> masks = new ArrayList<>();
            for (String s : arr) {
                int mask = 0;
                for (int i = 0; i < s.length(); i++) {
                    int ch = s.charAt(i) - 'a';
                    if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                        mask = 0;
                        break;
                    }
                    mask |= 1 << ch; // 将 ch 加入 mask 中
                }
                if (mask > 0) {
                    masks.add(mask);
                }
            }

            backtrack(masks, 0, 0);
            return ans;
        }

        public void backtrack(List<Integer> masks, int pos, int mask) {
            if (pos == masks.size()) {
                ans = Math.max(ans, Integer.bitCount(mask));
                return;
            }
            if ((mask & masks.get(pos)) == 0) { // mask 和 masks[pos] 无公共元素
                backtrack(masks, pos + 1, mask | masks.get(pos));
            }
            backtrack(masks, pos + 1, mask);
        }
    }



}
