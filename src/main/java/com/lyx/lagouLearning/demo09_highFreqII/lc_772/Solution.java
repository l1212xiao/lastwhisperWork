package com.lyx.lagouLearning.demo09_highFreqII.lc_772;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/3/20
 * <p>
 * ref:https://kaiwu.lagou.com/course/courseInfo.htm?courseId=3#/detail/pc?id=37
 * LeetCode 第 772 题，基本计算器：实现一个基本的计算器来计算简单的表达式字符串。
 * 说明：表达式字符串可以包含左括号(和右括号)，加号+和减号-，非负整数和空格。
 * 表达式字符串只包含非负整数，+-* /操作符，左括号(，右括号)和空格。整数除法需要向下截断。
 * <p>
 * 示例 1：
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2×(5+5×2)/3+(6/2+8)" = 21
 * "(2+6×3+5- (3×14/7+2)×5)+3" = -12
 */
public class Solution {
    // 在主函数里调用一个递归函数
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }
        queue.offer('+');
        return calculate(queue);
    }

    public int calculate(Queue<Character> queue) {
        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
                //遇到一个左括号，开始递归调用，求得括号里的计算结果，将它赋给当前的num
            } else if (c == '(') {
                num = calculate(queue);
            } else {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;

                //遇到右括号，就可以结束循环，直接返回当前的总和
                if (c == ')') {
                    break;
                }
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String cal = "2×(5+5×2)/3+(6/2+8)";
        int calculate = solution.calculate(cal);
        System.out.println(calculate);
    }
}
