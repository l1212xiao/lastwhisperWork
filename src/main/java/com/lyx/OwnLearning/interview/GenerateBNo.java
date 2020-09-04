package com.lyx.OwnLearning.interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lvyunxiao
 * @date 2020/8/11
 * <p>
 * https://www.geeksforgeeks.org/interesting-method-generate-binary-numbers-1-n/
 */
public class GenerateBNo {
    // This function uses queue data structure to print binary numbers
    public static void generatePrintBinary(int n) {
        // Create an empty queue of strings
        Queue<String> q = new LinkedList<>();

        // Enqueue the first binary number
        q.add("1");

        // This loops is like BFS of a tree with 1 as root
        // 0 as left child and 1 as right child and so on
        while (n-- > 0) {
            // print the front of queue
            // String s1 = q.peek();
            // q.remove();
            String s1 = q.poll();
            System.out.println(s1);

            // Store s1 before changing it
            // Append "0" to s1 and enqueue it
            q.add(s1 + "0");

            // Append "1" to s2 and enqueue it. Note that s2 contains
            // the previous front
            q.add(s1 + "1");
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int n = 10;
        generatePrintBinary(n);
    }
}
//This code is contributed by Sumit Ghosh