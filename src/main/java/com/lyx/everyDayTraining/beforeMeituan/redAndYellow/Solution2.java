package com.lyx.everyDayTraining.beforeMeituan.redAndYellow;

/*
https://leetcode-cn.com/problems/UlBDOe/
LCP 19. 秋叶收藏集
小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves，
字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。
每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。
请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。

示例 1：

输入：leaves = "rrryyyrryyyrr"
输出：2
解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"

示例 2：
输入：leaves = "ryr"
输出：0
解释：已符合要求，不需要额外操作

提示：
3 <= leaves.length <= 10^5
leaves 中只包含字符 'r' 和字符 'y'
 */

/*
思路
动态规划

使用 3 个 dp 数组记录状态

dp[0][i] 代表从头开始全部修改成红色（纯红）需要修改几次
dp[1][i] 代表从头开始是红色，然后现在是黄色（红黄），需要修改几次
dp[2][i] 代表从头开始是红色，然后变成黄色，又变成红色（红黄红），需要修改几次
根据 i 是红是黄，判断转移情况

dp[0][i] 就很简单，如果是黄的，就比之前加一
dp[1][i] 可以从上一个纯红状态变化过来，也可以从上一个本身状态变化过来
dp[2][i] 可以从上一个红黄状态变化过来，也可以从上一个本身状态变化过来
所以最后要求的答案即：dp[2][n]


作者：ikaruga
链接：https://leetcode-cn.com/problems/UlBDOe/solution/ulbdoe-by-ikaruga/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


/**
 * @author lvyunxiao
 * @date 2020/9/14
 */
public class Solution2 {
    public int minimumOperations(String leaves) {
        if (leaves == null || leaves.length() == 0) {
            return 0;
        }
        char[] leaveChars = leaves.toCharArray();
        int n = leaveChars.length;
        int[][] dp = new int[3][n];
        for (int i = 0; i < 3; i++) {
            dp[i][0] = (leaveChars[0] == 'r' ? 0 : 1);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + (leaveChars[i] == 'r' ? 0 : 1);
            dp[1][i] = Math.min(dp[0][i - 1] + (leaveChars[i] == 'y' ? 0 : 1),
                    dp[1][i - 1] + (leaveChars[i] == 'y' ? 0 : 1));
            if (i == 1) {   // i < 2
                dp[2][1] = dp[1][1];
            } else {
                dp[2][i] = Math.min(dp[1][i - 1] + (leaveChars[i] == 'r' ? 0 : 1),
                        dp[2][i - 1] + (leaveChars[i] == 'r' ? 0 : 1));
            }
        }
        return dp[2][n - 1];
    }

    public static void main(String[] args) {

        // String leaves = "rrryyyrryyyrr";
        String leaves = "yry";
        Solution2 s = new Solution2();
        int minimumOperations = s.minimumOperations(leaves);
        System.out.println(minimumOperations);

    }

}
