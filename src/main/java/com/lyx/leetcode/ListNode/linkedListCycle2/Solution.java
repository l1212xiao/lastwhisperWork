package com.lyx.ListNode.linkedListCycle2;

import com.lyx.ListNode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyx on 2018/5/11.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            if (list.contains(cur)) {
                return cur;
            }
            list.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
