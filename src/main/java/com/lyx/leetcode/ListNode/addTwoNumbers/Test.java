package com.lyx.leetcode.ListNode.addTwoNumbers;

import com.lyx.leetcode.ListNode.ListNode;

/**
 * Created by lyx on 2018/5/10.
 */
public class Test {
    public static void main(String[] args) {
/*
        int sum = 807;
        char[] chars = Integer.toString(sum).toCharArray();
        System.out.println(Integer.parseInt(String.valueOf(chars[1])));
*/
        SolutionOrg solution = new SolutionOrg();

        ListNode l1 = new ListNode(2);
        ListNode l1a = new ListNode(4);
        ListNode l1b = new ListNode(3);
        l1.next = l1a;
        l1a.next = l1b;

        ListNode l2 = new ListNode(5);
        ListNode l2a = new ListNode(6);
        ListNode l2b = new ListNode(4);
        l2.next = l2a;
        l2a.next = l2b;

        ListNode listNode = solution.addTwoNumbers(l1, l2);
        //System.out.println((807/100)%10);

        //System.out.println(solution.listToSum(l2,0,0));

        //System.out.println((9 + 999999991));

        while (listNode != null) {
            if (listNode.next == null) {
                System.out.print(listNode.val);
            } else {
                System.out.print(listNode.val + "->");
            }
            listNode = listNode.next;
        }

        System.out.println("\n");

    }
}
