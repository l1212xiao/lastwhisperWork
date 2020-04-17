package com.lyx.lagouLearning.demo11_highIV.lc_336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/4/14
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                if (isPalindrom(words[i] + words[j])) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public boolean isPalindrom(String word) {
        return isPalindrom(word, 0, word.length() - 1);
    }

    public boolean isPalindrom(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
