package com.lyx.lagouLearning.demo01_base.Stack.dailyTemperatures;

import java.util.Stack;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2019/12/3
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void printInts(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                System.out.print(nums[i] + ",");
            } else {
                System.out.println(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        printInts(test);
        int[] dailyTemperatures = solution.dailyTemperatures(test);
        printInts(dailyTemperatures);
    }
}
