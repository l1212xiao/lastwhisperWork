package com.lyx.leetcode.Array.reverse;

/**
 * @Classname SolutionOrg
 * @Description TODO
 * @Date 2019/7/13 15:45
 * @Created by lvyunxiao
 */

/**
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/zheng-shu-fan-zhuan-by-leetcode/
 * 反转整数的方法可以与反转字符串进行类比。
 * <p>
 * 我们想重复“弹出” xx 的最后一位数字，并将它“推入”到 \text{rev}rev 的后面。最后，\text{rev}rev 将与 xx 相反。
 * <p>
 * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
 * <p>
 * //pop operation:
 * pop = x % 10;
 * x /= 10;
 * <p>
 * //push operation:
 * temp = rev * 10 + pop;
 * rev = temp;
 */
public class SolutionOrg {
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            int pop = x % 10;
            rev = rev * 10 + pop;

            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) rev;
    }
}
