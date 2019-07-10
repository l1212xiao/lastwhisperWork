package com.lyx.leetcode.ListNode.addTwoNumbers;

/**
 * @Classname SolutionOrg
 * @Description leetcode
 * @Date 2019/7/9 19:51
 * @Created by lvyunxiao
 */

import com.lyx.leetcode.ListNode.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
 * 伪代码如下：
 * <p>
 * 将当前结点初始化为返回列表的哑结点。
 * 将进位 carry 初始化为 0。
 * 将 p 和 q 分别初始化为列表 l1 和 l2 的头部。
 * 遍历列表 l1l1 和 l2l2 直至到达它们的尾端。
 * *将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
 * *将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
 * *设定 sum = x + y + carry。
 * *更新进位的值，carry = sum / 10。
 * *创建一个数值为 (sum mod 10)的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
 * *同时，将 p 和 q 前进到下一个结点。
 * 检查 carry = 1是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
 * 返回哑结点的下一个结点。
 * 请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。
 * <p>
 */
public class SolutionOrg {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            cur = cur.next;

        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

}
