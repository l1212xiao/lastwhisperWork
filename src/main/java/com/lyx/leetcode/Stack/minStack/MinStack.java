package com.lyx.Stack.minStack;

import java.util.Stack;

/**
 * Created by lyx on 2018/5/13.
 * 155. Min Stack
 */
class MinStack {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */