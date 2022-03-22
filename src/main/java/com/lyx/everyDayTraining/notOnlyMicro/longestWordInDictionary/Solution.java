package com.lyx.everyDayTraining.notOnlyMicro.longestWordInDictionary;

/*
720. 词典中最长的单词
给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。

示例 1：

输入：words = ["w","wo","wor","worl", "world"]
输出："world"
解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。

示例 2：

输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出："apple"
解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"


提示：
    1 <= words.length <= 1000
    1 <= words[i].length <= 30
    所有输入的字符串 words[i] 都只包含小写字母。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lvyunxiao
 * @date 2022/3/17
 * @description
 */
public class Solution {

    /*
    太墨迹了，哎，需要优化下
    public String longestWord(String[] words) {
        List<String> wordList = new ArrayList<>();
        List<String> ansList = new ArrayList<>();
        int n = words.length;
        if (n == 1) {
            return words[0];
        }
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                return o1.compareTo(o2);
            }
        });
        // Arrays.sort(words);
        for (String word : words) {
            wordList.add(word);
        }
        // 表示word[i]是符合条件的单词
        Map<String, Boolean> map = new HashMap<>();

        int curLongest = 0;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int length = word.length();
            if (length <= 1) {
                map.put(word, true);
            } else {
                String subWord = word.substring(0, length - 1);
                if (wordList.contains(subWord) && map.containsKey(subWord) && map.get(subWord)) {
                    map.put(word, true);
                } else {
                    map.put(word, false);
                }
            }
            if (map.get(word)) {
                if (length > curLongest) {
                    ansList.clear();
                    ansList.add(word);
                    curLongest = length;
                } else if (length == curLongest) {
                    ansList.add(word);
                }
            }
        }
        if (ansList.isEmpty()) {
            return "";
        }
        return ansList.get(0);
    }
     */

    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        String longest = "";
        Set<String> candidates = new HashSet<>();
        candidates.add("");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (candidates.contains(word.substring(0, word.length() - 1))) {
                candidates.add(word);
                longest = word;
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // String[] words = {"w", "wo", "wor", "worl", "world"};
        // String[] words = {"w", "wor", "worl", "wo", "ab", "world"};
        String[] words = {"wo", "wor", "worl", "world"};
        String longestWord = s.longestWord(words);
        System.out.println(longestWord);
    }

}
