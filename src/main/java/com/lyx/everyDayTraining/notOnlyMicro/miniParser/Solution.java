package com.lyx.everyDayTraining.notOnlyMicro.miniParser;

/*
385. 迷你语法分析器

给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。
列表中的每个元素只可能是整数或整数嵌套列表

示例 1：

输入：s = "324",
输出：324
解释：你应该返回一个 NestedInteger 对象，其中只包含整数值 324。

示例 2：

输入：s = "[123,[456,[789]]]",
输出：[123,[456,[789]]]
解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
1. 一个 integer 包含值 123
2. 一个包含两个元素的嵌套列表：
    i.  一个 integer 包含值 456
    ii. 一个包含一个元素的嵌套列表
         a. 一个 integer 包含值 789



提示：

    1 <= s.length <= 5 * 104
    s 由数字、方括号 "[]"、负号 '-' 、逗号 ','组成
    用例保证 s 是可解析的 NestedInteger
    输入中的所有值的范围是 [-106, 106]


 */

/**
 * @author lvyunxiao
 * @date 2022/4/15
 * @description
 */

import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */


class Solution {

    int index = 0;

    public NestedInteger deserialize(String s) {
        if (s.charAt(index) == '[') {
            index++;
            NestedInteger ni = new NestedInteger();
            while (s.charAt(index) != ']') {
                ni.add(deserialize(s));
                if (s.charAt(index) == ',') {
                    index++;
                }
            }
            index++;
            return ni;
        } else {
            boolean negative = false;
            if (s.charAt(index) == '-') {
                negative = true;
                index++;
            }
            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index) - '0';
                index++;
            }
            if (negative) {
                num *= -1;
            }
            return new NestedInteger(num);
        }
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface INestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(INestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<INestedInteger> getList();
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger implements INestedInteger {

        // Constructor initializes an empty nested list.
        public NestedInteger() {

        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {

        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        @Override
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        @Override
        public Integer getInteger() {
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        @Override
        public void setInteger(int value) {

        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        @Override
        public void add(INestedInteger ni) {

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        @Override
        public List<INestedInteger> getList() {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "[123,[456,[789]]]";
        NestedInteger deserialize = s.deserialize(str);

        System.out.println(deserialize);
    }


}





