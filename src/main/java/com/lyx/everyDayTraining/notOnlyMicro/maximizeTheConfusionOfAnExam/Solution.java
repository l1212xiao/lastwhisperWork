package com.lyx.everyDayTraining.notOnlyMicro.maximizeTheConfusionOfAnExam;

/*
2024. 考试的最大困扰度

一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。
老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
    每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。


示例 1：

输入：answerKey = "TTFF", k = 2
输出：4
解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
总共有四个连续的 'T' 。

示例 2：

输入：answerKey = "TFFT", k = 1
输出：3
解释：我们可以将最前面的 'T' 换成 'F' ，得到 answerKey = "FFFT" 。
或者，我们可以将第二个 'T' 换成 'F' ，得到 answerKey = "TFFF" 。
两种情况下，都有三个连续的 'F' 。

示例 3：

输入：answerKey = "TTFTTFTT", k = 1
输出：5
解释：我们可以将第一个 'F' 换成 'T' ，得到 answerKey = "TTTTTFTT" 。
或者我们可以将第二个 'F' 换成 'T' ，得到 answerKey = "TTFTTTTT" 。
两种情况下，都有五个连续的 'T' 。


提示：
    n == answerKey.length
    1 <= n <= 5 * 104
    answerKey[i] 要么是 'T' ，要么是 'F'
    1 <= k <= n

 */


/**
 * @author lvyunxiao
 * @date 2022/3/29
 * @description
 */
public class Solution {

    /*


    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        if (n == 0 || n == 1) {
            return n;
        }
        int max = 1;
        char[] ans = answerKey.toCharArray();
        // dpT[i][j]表示，经过i次操作，以字母下标为j结尾的字符串，T最大的长度
        // dpF[i][j]表示，经过i次操作，以字母下标为j结尾的字符串，F最大的长度
        int[][] dpT = new int[k][n];
        int[][] dpF = new int[k][n];
        for (int i = 0; i < k; i++) {
            dpT[i][0] = ans[0] == 'T' ? 1 : 0;
            dpF[i][0] = ans[0] == 'F' ? 1 : 0;
            max = Math.max(max, dpT[i][0]);
            max = Math.max(max, dpF[i][0]);
        }
        for (int i = 1; i < n; i++) {
            dpT[0][i] = ans[i] == 'T' ? ans[i - 1] + 1 : 0;
            dpF[0][i] = ans[i] == 'F' ? ans[i - 1] + 1 : 0;
            max = Math.max(max, dpT[0][i]);
            max = Math.max(max, dpF[0][i]);
        }
        for (int i = 1; i < k; i++) {
            for (int j = 1; j < n; j++) {
                // 无法处理操作次数
                dpT[i][j] = ans[j] == 'T' ? dpT[i][j - 1] + 1 : dpT[i - 1][j - 1] + 1;
                dpT[i][j] = ans[j] == 'F' ? dpF[i][j - 1] + 1 : dpF[i - 1][j - 1] + 1;
            }
        }
        return max;
    }
     */


    /*
    方法一：滑动窗口
    思路和算法
    只要求最大连续指定字符的数目时，本题和「1004. 最大连续1的个数 III」完全一致。
    在指定字符的情况下，我们可以计算其最大连续数目。具体地，我们使用滑动窗口的方法，从左到右枚举右端点，
    维护区间中另一种字符的数量为 sum，当 sum 超过 k，我们需要让左端点右移，直到 sum≤k。
    移动过程中，我们记录滑动窗口的最大长度，即为指定字符的最大连续数目。
    本题的答案为分别指定字符为 T 和 F 时的最大连续数目的较大值。

    */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    public int maxConsecutiveChar(String answerKey, int k, char ch) {
        int n = answerKey.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            sum += answerKey.charAt(right) != ch ? 1 : 0;
            while (sum > k) {
                sum -= answerKey.charAt(left) != ch ? 1 : 0;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
