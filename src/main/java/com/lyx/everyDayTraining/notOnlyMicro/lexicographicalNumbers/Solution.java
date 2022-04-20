package com.lyx.everyDayTraining.notOnlyMicro.lexicographicalNumbers;

/*
386. 字典序排数

给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。

示例 1：

输入：n = 13
输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]

示例 2：

输入：n = 2
输出：[1,2]

提示：
    1 <= n <= 5 * 10^4
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/4/18
 * @description
 */
public class Solution {
    
    /*
    那么对于一个整数 number，它的下一个字典序整数对应下面的规则：
    尝试在 number 后面附加一个零，即 number×10，如果 number×10≤n，那么说明 number×10 是下一个字典序整数；
    如果 number mod 10 = 9 或 number+1>n，那么说明末尾的数位已经搜索完成，退回上一位，即 number=number / 10，
    然后继续判断直到 number mod 10 ≠ 9 且 number+1≤n 为止，那么 number+1 是下一个字典序整数。
    字典序最小的整数为 number=1，我们从它开始，然后依次获取下一个字典序整数，加入结果中，结束条件为已经获取到 n 个整数。
     */

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            ans.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                while (cur % 10 == 9 || cur + 1 > n) {
                    cur /= 10;
                }
                cur++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // int n = 13;
        // int n = 2;
        int n = 200;
        List<Integer> lexicalOrder = s.lexicalOrder(n);
        System.out.println(Arrays.toString(lexicalOrder.toArray()));

    }
}
