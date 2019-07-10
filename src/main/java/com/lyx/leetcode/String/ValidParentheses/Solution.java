package com.lyx.leetcode.String.ValidParentheses;

import java.util.Stack;

/**
 * Created by lyx on 2018/8/15.
 * 20. Valid Parentheses
 * 括号匹配
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '(') stack.push(')');
            else if (x == '[') stack.push(']');
            else if (x == '{') stack.push('}');
            else {
                if (stack.empty() || stack.peek() != x) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
