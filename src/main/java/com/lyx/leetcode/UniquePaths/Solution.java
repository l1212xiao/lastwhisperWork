package com.lyx.Path.UniquePaths;

/**
 * Created by lyx on 2018/7/4.
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 0;
        }
        if (n == 1) {
            return m - 1;
        } else if (m == 1) {
            return n - 1;
        }
        return getFac(m + n - 1 - 1) / getFac(m - 1) / getFac(n - 1);

    }

    public static int getFac(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

}
