package com.lyx.leetcode.MyOwn.bracketMatch;

import java.util.Stack;

/**
 * Created by lyx on 2018/9/21
 */
public class BracketMatch {

    public static boolean isMatch(String str) {

        Stack<Character> stack = new Stack<>();
        String backets = "()[]{}";
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);

            if (!backets.contains(c.toString())) {
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == '(' && c == ')'
                    || stack.peek() == '[' && c == ']'
                    || stack.peek() == '{' && c == '}') {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        String string = "a()a(bb)[dd(dd)dd]cc{ee}";
        System.out.println(isMatch(string));
    }
}
