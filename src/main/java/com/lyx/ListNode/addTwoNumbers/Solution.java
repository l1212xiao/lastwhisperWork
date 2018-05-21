package com.lyx.ListNode.addTwoNumbers;

import com.lyx.ListNode.ListNode;

/**
 * Created by lyx on 2018/5/10.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode resuliList = new ListNode(0);

        int sum1 = listToSum(l1, 0, 0);
        int sum2 = listToSum(l2, 0, 0);
        int sumTotal = sum1 + sum2;

        int length = Integer.toString(sumTotal).length();
        int[] nums = new int[length];

        int pow = length;

        for (int i = 0; i < length; i++) {
            nums[i] = (sumTotal / ((int) Math.pow(10, pow - 1))) % 10;
            pow--;
        }

        ListNode cur = resuliList;
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode tmp = new ListNode(0);
            cur.val = nums[i];
            if (i > 0) {
                cur.next = tmp;
                cur = cur.next;
            }
        }

        return resuliList;
    }

    public int listToSum(ListNode l1, int sum, int power) {
        while (l1 != null) {
            sum += (l1.val * ((int) Math.pow(10, power)));
            l1 = l1.next;
            power++;
        }
        return sum;
    }
}
