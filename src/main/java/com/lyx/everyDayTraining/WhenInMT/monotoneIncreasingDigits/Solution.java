package com.lyx.everyDayTraining.WhenInMT.monotoneIncreasingDigits;

/*
738. 单调递增的数字
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
示例 1:

输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299
 */

/**
 * @author lvyunxiao
 * @date 2020/12/15
 * @description
 */
public class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (checkIncrease(N)) {
            return N;
        } else {
            return monotoneIncreasingDigits(N - 1);
        }
    }

    public boolean checkIncrease(int n) {
        if (n < 10) {
            return true;
        }
        if (n % 10 >= (n / 10) % 10) {
            return checkIncrease(n / 10);
        } else {
            return false;
        }
    }

    /*
    既然要尽可能的大，那么这个数从高位开始要尽可能地保持不变，从低位向高位遍历，
    每次保证当前位到最低位组成的数字是递增的

    例子：数字 1101 最大单调递增数为 999
    从低位向高位遍历，到0时发现前面有一个1>0，这里将后两位置为99，同时向高位“借位”，
    前两位变成11-1=10；此时num = 1099
    继续遍历又发现1>0，重复上述步骤得到结果999

    时间复杂度O(logN)
    空间复杂度O(1)

    作者：bei-ye-qing-yang
    链接：https://leetcode-cn.com/problems/monotone-increasing-digits/solution/java-ologn-bu-xu-yao-zhuan-zi-fu-chuan-b-b7lk/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int monotoneIncreasingDigits2(int N) {
        int res = 0;
        // 倍数
        int seed = 1;
        while (N > 0) {
            int num = N % 10;
            N /= 10;
            int high = N % 10;
            if (high > num) {
                // 高位大于低位，将低位全部置为9，高位数字-1
                res = seed * 10 - 1;
                N -= 1;
            } else {
                res = num * seed + res;
            }
            seed *= 10;
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // int N = 10;
        // int N = 332;
        int N = 963856657;
        int digits = s.monotoneIncreasingDigits(N);
        System.out.println(digits);
    }

}
