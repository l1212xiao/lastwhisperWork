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


}
