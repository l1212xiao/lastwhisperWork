package com.lyx.ctj.trans;

import java.util.Stack;

public class OutermostParentheses {
	public static void main(String[] args) {
		String input = "(abc(def)ghi(jkl)mno)pqr"; // 输入的字符串
		String content = getOutermostParenthesesContent(input);
		System.out.println("最外层括号里面的内容: " + content);
	}

	public static String getOutermostParenthesesContent(String input) {
		Stack<Integer> stack = new Stack<>();
		int start = -1;
		int end = -1;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(') {
				if (stack.isEmpty()) {
					start = i + 1; // 记录最外层左括号的位置
				}
				stack.push(i);
			} else if (c == ')' && !stack.isEmpty()) {
				stack.pop();
				if (stack.isEmpty()) {
					end = i; // 记录最外层右括号的位置
					break; // 找到最外层括号对，结束循环
				}
			}
		}

		if (start != -1 && end != -1 && start < end) {
			return input.substring(start, end);
		} else {
			return ""; // 没有找到最外层括号对，返回空字符串
		}
	}
}

