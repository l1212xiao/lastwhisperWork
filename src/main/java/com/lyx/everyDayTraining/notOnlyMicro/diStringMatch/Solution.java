package com.lyx.everyDayTraining.notOnlyMicro.diStringMatch;

/*
942. 增减字符串匹配
由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
    如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
    如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。

示例 1：

输入：s = "IDID"
输出：[0,4,1,3,2]

示例 2：

输入：s = "III"
输出：[0,1,2,3]

示例 3：

输入：s = "DDI"
输出：[3,2,0,1]

提示：
    1 <= s.length <= 10^5
    s 只包含字符 "I" 或 "D"
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/5/9
 * @description
 */
public class Solution {

    /* 回溯，有误写法
    public int[] diStringMatch(String s) {
        int n = s.length();
        boolean[] visited = new boolean[n + 1];
        List<Integer> ansList = new ArrayList<>();
        dfs(ansList, visited, 0, s);
        int[] ans = new int[n];
        for (int i = 0; i < n + 1; i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    private void dfs(List<Integer> ansList, boolean[] visited, int index, String s) {
        int n = s.length();
        if (ansList.size() == n + 1) {
            return;
        }
        for (int i = 0; i < n + 1; i++) {
            char c = s.charAt(index);
            if (!visited[i]) {
                if (ansList.isEmpty()) {
                    visited[i] = true;
                    ansList.add(i);
                    dfs(ansList, visited, index, s);
                } else {
                    Integer last = ansList.get(ansList.size() - 1);
                    if ((last < i && c == 'I') || last > i && c == 'D') {
                        visited[i] = true;
                        ansList.add(i);
                        dfs(ansList, visited, index + 1, s);
                    } else {
                        continue;
                    }
                }
            }
        }
    }
     */

    /*
    方法一：贪心

    考虑 perm[0] 的值，根据题意：

    如果 s[0]=‘I’，那么令 perm[0]=0，则无论 perm[1] 为何值都满足 perm[0]<perm[1]；
    如果 s[0]=‘D’，那么令 perm[0]=n，则无论 perm[1] 为何值都满足 perm[0]>perm[1]；

    确定好 perm[0] 后，剩余的 n−1 个字符和 n 个待确定的数就变成了一个和原问题相同，
    但规模为 n−1 的问题。因此我们可以继续按照上述方法确定 perm[1]：如果 s[1]=‘I’，那么令 perm[1] 为剩余数字中的最小数；
    如果 s[1]=‘D’，那么令 perm[1] 为剩余数字中的最大数。如此循环直至剩下一个数，perm[n] 中。
    */
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int curMin = 0, curMax = n;
        for (int i = 0; i < n; i++) {
            ans[i] = s.charAt(i) == 'I' ? curMin++ : curMax--;
        }
        ans[n] = curMin;
        return ans;
    }

}
