package com.lyx.everyDayTraining.countNumbersWithUniqueDigits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lvyunxiao
 * @date 2020/9/9
 * <p>
 * 357. 计算各个位数不同的数字个数
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10^n
 * <p>
 * 示例:
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        List<String> res = new ArrayList<>();
        backtrack(n, n, "", res);
        System.out.println("==========");
        System.out.println(Arrays.toString(res.toArray()));
        System.out.println("==========");
        return res.size();
    }

    public void backtrack(int n, int rest, String cur, List<String> res) {
        if (rest == 0) {
            int value = Integer.parseInt(cur);
            String curNum = Integer.toString(value);
            char[] chars = curNum.toCharArray();
            Set<Character> set = new HashSet<>();
            for (char c : chars) {
                set.add(c);
            }
            if (set.size() == curNum.length()) {
                res.add(cur);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            cur += i;
            backtrack(n, rest - 1, cur, res);
            cur = cur.substring(0, cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int uniqueDigits = solution.countNumbersWithUniqueDigits(n);
        System.out.println(uniqueDigits);
    }
}
