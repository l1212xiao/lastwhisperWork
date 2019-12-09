package com.lyx.lagouLearning.demo01.Stack.implementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lvyunxiao
 * @classname MyStack
 * @description MyStack
 * @date 2019/12/9
 */
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q2 = q1;
        q1 = new LinkedList<>();//q1留空，目的是每次新加入的元素都在q1队列的front
        q1.offer(x);//q1的front加入x
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
