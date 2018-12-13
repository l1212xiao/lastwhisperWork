package com.lyx.ListNode.linkedListCycle;

import com.lyx.ListNode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyx on 2018/5/10.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            if (list.contains(cur)) {
                return true;
            }
            list.add(cur);
            cur = cur.next;
        }
        return false;
    }
}
