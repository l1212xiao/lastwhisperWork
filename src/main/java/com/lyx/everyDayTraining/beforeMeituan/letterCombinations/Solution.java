package com.lyx.everyDayTraining.beforeMeituan.letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvyunxiao
 * @date 2020/8/26
 * <p>
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/submissions/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrace(result, map, "", digits);
        return result;
    }

    // backtrace 是递归的
    // 传入参数: 当前记录，剩余记录 (存储记录 result)
    // 步骤：1.达到长度，借宿递归存入result，2.未达到记录结果，循环递归
    public void backtrace(List<String> result, Map<String, String> map, String combine, String next) {
        if (next.length() == 0) {
            result.add(combine);
        } else {
            String digit = next.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrace(result, map, combine + letter, next.substring(1));
            }
        }
    }
}
