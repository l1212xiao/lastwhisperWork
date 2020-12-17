package com.lyx.everyDayTraining.beforeMeituan.ngeTouZiDeDianShuLcof;

/*
剑指 Offer 60. n个骰子的点数
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

示例 1:

输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
示例 2:

输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]

限制：

1 <= n <= 11
 */

/*
动态规划（扫了一圈，俺是最短的）
弱鱼
发布于 2020-05-11
11.9k
题目大意：
简单来说，n个骰子同时掷出，题目要我们求每个点数的概率组成的数组（以下简称点数概率数组）

解题思路：
根据动态规划的思想分解子问题。
我们可以把n个骰子的点数分解为n-1个骰子的点数加上一个骰子的点数。
根据1个骰子的点数概率数组求出2的点数概率数组，根据2的点数概率数组求出3的点数概率数组....直到求出n的点数。
那么我们要怎么根据n-1个骰子的点数概率数组求出n个骰子的点数概率数组呢？
我们假设n=2。
则我们已知1的点数概率数组为{1/6d,1/6d,1/6d,1/6d,1/6d,1/6d}
我们要求的2个骰子，可以分解为n-1个骰子和1个骰子
同时易知2个骰子的点数概率数组长度为2*5+1。
则：
如图，x,y分别为n-1数组和1数组指针。
image.png
使得n-1点数概率数组和1点数概率数组元素两两相乘，并将乘积结果加到n点数概率数组上。
运算完成后就得到了最终的n点数概率数组。

基本思路如上，然后我们可以根据动态规划的套路：
1.构造dp数组：tmp[]为n个骰子的点数概率数组，pre[]为n-1个骰子的点数概率数组，一个骰子的点数概率数组显然是6个六分之一,不需要另设数组。
2.初始化dp数组：pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d}
3.构造状态转移方程:tmp[x+y]+=pre[x]*num[y];
 */
import java.util.Arrays;

/**
 * @author lvyunxiao
 * @date 2020/9/10
 */
public class Solution {
    public double[] twoSum(int n) {
        double[] pre = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int x = 0; x < 6; x++) {
                    tmp[j + x] += pre[j] / 6;
                }
            }
            pre = tmp;
        }
        return pre;
    }

    // 作者：zhi-xiong
    // 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/java-dong-tai-gui-hua-by-zhi-xiong/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 2;
        double[] twoSum = s.twoSum(n);
        System.out.println(Arrays.toString(twoSum));
    }
}
