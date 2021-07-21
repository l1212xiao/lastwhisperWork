package com.lyx.geek.AlgoMei;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @date 2021/7/7
 * @description
 */
public class StackDemo {

    /**
     * [LC.20]有效的括号
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (map.get(pop) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
