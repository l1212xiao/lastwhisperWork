package com.lyx.everyDayTraining.repeatedSubstringPattern;

/**
 * @author lvyunxiao
 * @date 2020/8/24
 */
public class Solution3 {

    public class Node{
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';

        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aba";
        Solution3 solution = new Solution3();
        boolean b = solution.repeatedSubstringPattern(s);
        System.out.println(b);
    }
}
