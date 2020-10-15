package com.lyx.everyDayTraining.findCommonCharacters;

/*
1002. 查找常用字符
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。

示例 1：

输入：["bella","label","roller"]
输出：["e","l","l"]
示例 2：

输入：["cool","lock","cook"]
输出：["c","o"]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/10/14
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        if (A == null || A.length == 0) {
            return ans;
        }
        for (int i = 0; i < A[0].length(); i++) {
            char c = A[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < A.length; j++) {
                if (i == A[j].length()) {
                    break;
                } else if (A[j].indexOf(c) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(String.valueOf(c));
                for (int j = 0; j < A.length; j++) {
                    int idx = A[j].indexOf(c);
                    if (idx == A[j].length() - 1) {
                        A[j] = A[j].substring(0, idx) + 'X';
                    } else {
                        A[j] = A[j].substring(0, idx) + 'X' + A[j].substring(idx + 1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输入：["bella","label","roller"]
        // 输出：["e","l","l"]
        Solution s = new Solution();
        // String[] A = {"bella", "label", "roller"};

        // 输入：["cool","lock","cook"]
        // 输出：["c","o"]
        String[] A = {"cool", "lock", "cook"};
        List<String> list = s.commonChars(A);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
