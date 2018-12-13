package com.lyx.String.cutLine;

/**
 * Created by lyx on 2018/4/17.
 * 动态规划
 */
public class Solution2 {
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

        //将最优解存储在数组内
        int[] products = new int[length + 1];

        //初始化变量，未减之前的状态
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        //数组中第i个元素表示把长度为i的绳子剪成若干段之后的乘积的最大值
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            //求出所有可能的f(j)*f(n-j)并比较出他们的最大值
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
            max = products[length];
        }
        return max;

    }
}
