package com.lyx.lagouLearning.demo01.Stack.validParentheses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/3
 * <p>
 * 这个简单，用一个栈来保存(，[,{
 * 当遍历到这三个字符的时候，就将其保存到栈中。
 * 如果遍历到的是)就从栈中弹出一个元素，检查是否能跟)配对
 * 如果遍历到的是]就从栈中弹出一个元素，检查是否能跟]配对
 * 如果遍历到的是}就从栈中弹出一个元素，检查是否能跟}配对
 * 怎么配对呢？
 * 这里用一个map来存储，key和value分别如下：
 * ) ：(
 * ] ：[
 * } ：{
 * 如果遍历到的是)，就可以从map中找到对应的value是(，再跟栈中弹出的元素对比就可以了。
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-parentheses/solution/duo-chong-jie-fa-dong-hua-yan-shi-20-you-xiao-de-g/
 */
public class Solution {
    public boolean isValid(String s) {
        // 构建map
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        // 用栈保存 (，[，{
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            // 如果map中不包含 (,[,{，就将这个字符放入栈中
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                // 取出栈顶的元素查看是否匹配map中的括号
                if (stack.empty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public boolean isValid2(String s) {
        if (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            return isValid2(s.replace("()", "")
                    .replace("[]", "")
                    .replace("{}", ""));
        } else {
            return "".equals(s);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(([{]})){}";
        boolean valid = solution.isValid2(s);
        System.out.println(valid);
    }
}
