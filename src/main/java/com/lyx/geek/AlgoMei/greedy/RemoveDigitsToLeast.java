package com.lyx.geek.AlgoMei.greedy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lvyunxiao
 * @date 2021/8/5
 * @description ref:https://blog.csdn.net/qq_40965479/article/details/106398369
 * 删除k个元素的最小值
 * * • 把原整数的所有数字从左到右进行比较，
 * * • 如果发现某一位数字大于它右面的数字，那么在删除该数字后，必然会使该数位的值降低，
 * * `  因为右面比它小的数字顶替了它的位置。
 * <p>
 * ref:https://leetcode-cn.com/problems/remove-k-digits/submissions/
 */
public class RemoveDigitsToLeast {

    /**
     * 删除k个元素的最小值
     */
    public String removeKdigits(String num, int k) {

        String newNum = num;
        for (int i = 0; i < k; i++) {
            // 是否找到要删除的数字
            boolean hasCut = false;

            for (int j = 0; j < newNum.length() - 1; j++) {
                if (newNum.charAt(j) > newNum.charAt(j + 1)) {
                    // substring 左闭右开区间 删除j下标元素
                    newNum = newNum.substring(0, j) + newNum.substring(j + 1, newNum.length());
                    hasCut = true;
                    break;
                }
            }
            if (newNum.length() == 0) {
                return "0";
            }
            // 如果没有找到则删除最后一个数字
            if (!hasCut) {
                newNum = newNum.substring(0, newNum.length() - 1);
            }
            // 清除整数左侧的0
            newNum = removeZero(newNum);
        }
        return newNum.length() == 0 ? "0" : newNum;
    }

    /**
     * 删除左侧的零
     *
     * @param newNums 有0的字符串
     * @return 没有零的字符串
     */
    private String removeZero(String newNums) {
        int index = 0;
        while (index < newNums.length() - 1) {
            if (newNums.charAt(index) == '0') {
                index++;
            } else {
                break;
            }
        }
        newNums = newNums.substring(index);
        return newNums;
    }

    // LC.402
    // 作者：LeetCode-Solution
    // 链接：https://leetcode-cn.com/problems/remove-k-digits/solution/yi-diao-kwei-shu-zi-by-leetcode-solution/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public String removeKdigits2(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }


    public static void main(String[] args) {
        RemoveDigitsToLeast s = new RemoveDigitsToLeast();
        // String num = "10001";
        // int k = 4;
        String num = "12345264";
        int k = 4;
        String kdigits = s.removeKdigits2(num, k);
        System.out.println(kdigits);

    }
}
