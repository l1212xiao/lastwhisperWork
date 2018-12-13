package com.lyx.swordOffer.UglyNumber;

/**
 * Created on 2018/12/13
 *
 * @author lvyunxiao
 */

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * ref:https://www.cnblogs.com/fankongkong/p/7455517.html
 */
public class Solution {
    public static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index < 7) {
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        //记录乘以 x 的个数，x = 2，3，5
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) {
                t2++;
            }
            if (res[i] == res[t3] * 3) {
                t3++;
            }
            if (res[i] == res[t5] * 5) {
                t5++;
            }
        }
        return res[index - 1];
    }

    public static void main(String[] args) {
        int uglyNumber = getUglyNumber(10);
        System.out.println(uglyNumber);
    }
}
