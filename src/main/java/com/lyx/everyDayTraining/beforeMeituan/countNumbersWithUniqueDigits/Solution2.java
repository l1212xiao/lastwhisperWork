package com.lyx.everyDayTraining.beforeMeituan.countNumbersWithUniqueDigits;

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
// 动态规划
public class Solution2 {
    /**
     * n > 10时，令n = 10
     * Sn为n位不同整数的值（一定是n个数字组成，第一位不能为0，且各个数字不同），
     * 如S3 = 648，
     * 结果：ans = S0 + S1 + ... + Sn
     * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits/solution/zhi-xing-yong-shi-0-ms-zai-suo-you-java-ti-jia-433/
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        int min = Math.min(10, n);
        int ans = 10;
        for (int i = 1; i < min; i++) {
            dp[i + 1] = dp[i] * (10 - i);
            ans += dp[i + 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int n = 10;
        int uniqueDigits = solution.countNumbersWithUniqueDigits(n);
        System.out.println(uniqueDigits);
    }
}
