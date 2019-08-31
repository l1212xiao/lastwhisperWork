package com.lyx.leetcode.Numbers.letterCombinationsOfAPhoneNumber;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Classname Solution
 * @Description Solution
 * @Date 2019/8/26
 * @auther lvyunxiao
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution {


    public List<String> letterCombinations(String digits) {
        Map<String, String> keyMap = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        char[] chars = digits.toCharArray();
        List<String> list = new ArrayList<>();
        for (final char aChar : chars) {
            list.add(String.valueOf(aChar));
        }

        List<String> result = new ArrayList<>();
        Set<String> numValues = list.stream().map(x -> keyMap.get(x)).collect(Collectors.toSet());
        //Set<List<String>> lists = Sets.cartesianProduct(numValues, numValues);

        for (final String numValue : numValues) {
            char[] chars1 = numValue.toCharArray();

        }

        return result;

    }


    public static void main(String[] args) {
//        ImmutableSet<Character> charList = ImmutableSet.of('a', 'b', 'c');
//        Set<List<Character>> set = Sets.cartesianProduct(charList, charList, charList);
//        for (List<Character> characters : set) {
//            System.out.println(characters);
//        }
//        System.out.println(Integer.valueOf("1"));
        Solution solution = new Solution();
        List<String> list = solution.letterCombinations("23");
        list.stream().forEach(System.out::println);
    }
}
