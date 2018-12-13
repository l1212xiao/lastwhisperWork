package com.lyx.Numbers.ClimbingStairs;

/**
 * Created by lyx on 2018/5/14.
 * 70. Climbing Stairs
 */
public class Solution {
    public int climbStairs(int n) {
        int f1 = 1;
        int f2 = 2;

        if (n == 1) return 1;
        if (n == 2) return 2;

        for (int i = 3; i <=n ; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
