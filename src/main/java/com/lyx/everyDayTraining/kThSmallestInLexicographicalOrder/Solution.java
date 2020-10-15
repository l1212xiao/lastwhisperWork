package com.lyx.everyDayTraining.kThSmallestInLexicographicalOrder;

/*
440. 字典序的第K小数字
给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。

注意：1 ≤ k ≤ n ≤ 109。

示例 :

输入:
n: 13   k: 2

输出:
10

解释:
字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 */

/*
首先这个题建议好兄弟们先自己手画一个图，理解一下。
我们的目标是第k小的数值，那么就是要从前面开始一一排除答案，
举例子：最小的肯定就是1，然后如果k大于等于1，也就是要的在后面，那么我们就顺着往下找。
1的下一层有10个，但是在找的时候，要考虑一下题目给的n值，如果比如如果n值是13，那么下一层就不是10个而是13 - 10 + 1，四个
转换成代码就是
steps = steps + Math.min((long)n+1,last) - first;//last指19，first指10
以上仅指这个例子
下一层就是 100-109那么我们什么时候才会结束这个循环呢，
当first大于 n的时候，就没有必要进行下去了。这个时候我们也肯定得到了我们想要的值，也就是1开头的所有节点的值。
就在steps里面
然后比较一下steps和k的大小，如果steps比k大，好家伙，包括了，我们找到了，这个答案的开头肯定是1，那我们把curr* 10.就再次循环，找就完事了，记得把k-1,因为1已经被排除了
如果k比steps小，坏事，在一个节点，也就是2开头的接着找吧，但是要记得k = k - steps curr += 2;

作者：lengchunjiang
链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/chu-kan-ye-shi-kan-bu-dong-xi-wang-neng-bang-dao-n/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


/**
 * @author lvyunxiao
 * @date 2020/10/9
 */
public class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k = k - 1;//扣除掉第一个0节点
        while (k > 0) {
            int num = getNode(n, cur, cur + 1);
            if (num <= k) {//第k个数不在以cur为根节点的树上
                cur += 1;//cur在字典序数组中从左往右移动
                k -= num;
            } else {//在子树中
                cur *= 10;//cur在字典序数组中从上往下移动
                k -= 1;//刨除根节点
            }
        }
        return cur;
    }

    public int getNode(int n, long first, long last) {
        int num = 0;
        while (first <= n) {
            num += Math.min(n + 1, last) - first;//比如n是195的情况195到100有96个数
            first *= 10;
            last *= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 13, k = 2;
        int kthNumber = s.findKthNumber(n, k);
        System.out.println(kthNumber);
    }
}
