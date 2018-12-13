package com.lyx.String.cutLine;

/**
 * Created by lyx on 2018/4/17.
 * 贪婪算法
 */
public class Solution {

    public int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int timeOf3 = length / 3;
        if (length - timeOf3 * 3 == 1) {
            timeOf3 -= 1;
        }

        int timeOf2 = (length - 3 * timeOf3) / 2;

        return (int) (Math.pow(3, timeOf3) * Math.pow(2, timeOf2));
    }

}
