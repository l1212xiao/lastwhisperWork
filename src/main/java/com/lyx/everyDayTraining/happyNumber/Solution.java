package com.lyx.everyDayTraining.happyNumber;

/*
202. 快乐数
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，
也可能是 无限循环 但始终变不到 1。
如果 可以变为 1，那么这个数就是快乐数。
如果 n 是快乐数就返回 True ；不是，则返回 False 。

示例：

输入：19
输出：true
解释：
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 02 = 1
 */


import java.util.HashSet;
import java.util.Set;

/**
 * @author lvyunxiao
 * @date 2020/9/29
 */
public class Solution {
    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        if (set.contains(n)) {
            return false;
        }
        set.add(n);
        int newN = 0;
        while (n != 0) {
            int i = n % 10;
            newN += i * i;
            n /= 10;
        }
        return isHappy(newN);
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy2(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    // 快慢指针
    public boolean isHappy3(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    // 作者：LeetCode-Solution
    // 链接：https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Solution s = new Solution();
        // int n = 19;
        int n = 116;
        boolean happy = s.isHappy(n);
        System.out.println(happy);
    }
}
