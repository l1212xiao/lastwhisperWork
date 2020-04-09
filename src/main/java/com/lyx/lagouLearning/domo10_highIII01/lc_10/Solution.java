package com.lyx.lagouLearning.domo10_highIII01.lc_10;

/**
 * @author lvyunxiao
 * @classname Solution
 * @description Solution
 * @date 2020/4/9
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();

        // 看看pattern和字符串是否都扫描完毕
        if (j == n) {
            return i == m;
        }

        // next char is not '*': 必须满足当前字符并递归到下一层
        if (j == n - 1 || p.charAt(j + 1) != '*') {
            return (i < m) && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
                    && isMatch(s, i + 1, p, j + 1);
        }

        // next char is '*', 如果有连续的s[i]出现并且都等于p[j]，一直尝试下去
        if (j < n - 1 && p.charAt(j + 1) == '*') {
            while ((i < m) && (p.charAt(j) == '.') || s.charAt(i) == p.charAt(j)) {
                if (isMatch(s, i, p, j + 2)) {
                    return true;
                }
                i++;
            }
        }

        // 接着继续下去
        return isMatch(s, i, p, j + 2);
    }
}
