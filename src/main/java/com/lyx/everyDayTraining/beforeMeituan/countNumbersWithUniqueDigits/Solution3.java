package com.lyx.everyDayTraining.beforeMeituan.countNumbersWithUniqueDigits;

/**
 * @author lvyunxiao
 * @date 2020/9/9
 * <p>
 * 作者：rainlight
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits/solution/javaduo-jie-fa-hui-su-dong-tai-gui-hua-mei-ju-by-r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution3 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        return dfs(Math.min(10, n), 0, new boolean[10]);
    }

    private int dfs(int n, int idx, boolean[] used) {
        int count = 0;
        if (idx != n) {
            for (int i = 0; i < 10; i++) {
                // 剪枝：多位数时，第一个数字不能为0
                if (i == 0 && n > 1 && idx == 1) {
                    continue;
                }
                // 剪枝：不能使用用过的数字
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                count += dfs(n, idx + 1, used) + 1;
                used[i] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int n = 2;
        int uniqueDigits = solution.countNumbersWithUniqueDigits(n);
        System.out.println(uniqueDigits);
    }
}
