package com.lyx.everyDayTraining.microDream.findTheCelebrity;

/*
277. 搜寻名人

假设你是一个专业的狗仔，参加了一个 n 人派对，其中每个人被从 0 到 n - 1 标号。在这个派对人群当中可能存在一位 “名人”。
所谓 “名人” 的定义是：其他所有 n - 1 个人都认识他/她，而他/她并不认识其他任何人。
现在你想要确认这个 “名人” 是谁，或者确定这里没有 “名人”。而你唯一能做的就是问诸如 “A 你好呀，请问你认不认识 B呀？” 的问题，
以确定 A 是否认识 B。你需要在（渐近意义上）尽可能少的问题内来确定这位 “名人” 是谁（或者确定这里没有 “名人”）。

在本题中，你可以使用辅助函数 bool knows(a, b) 获取到 A 是否认识 B。请你来实现一个函数 int findCelebrity(n)。
派对最多只会有一个 “名人” 参加。若 “名人” 存在，请返回他/她的编号；若 “名人” 不存在，请返回 -1。

示例 1:

输入: graph = [
  [1,1,0],
  [0,1,0],
  [1,1,1]
]
输出: 1
解释: 有编号分别为 0、1 和 2 的三个人。graph[i][j] = 1 代表编号为 i 的人认识编号为 j 的人，
而 graph[i][j] = 0 则代表编号为 i 的人不认识编号为 j 的人。“名人” 是编号 1 的人，因为 0 和 2 均认识他/她，但 1 不认识任何人。

示例 2:

输入: graph = [
  [1,0,1],
  [1,1,0],
  [0,1,1]
]
输出: -1
解释: 没有 “名人”

提示：
    n == graph.length
    n == graph[i].length
    2 <= n <= 100
    graph[i][j] 是 0 或 1.
    graph[i][i] == 1

进阶：如果允许调用 API knows 的最大次数为 3 * n ，你可以设计一个不超过最大调用次数的解决方案吗？
 */


/**
 * @author lvyunxiao
 * @date 2022/4/19
 * @description
 */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
public class Solution {

    /*
    解题思路
我们不妨先假定ans为0，然后迭代n个人，如果此时ans认识某个人k(0<=k<n),那么令ans为k；
如何证明若存在名人，则名人必定为ans呢？
我们知道如果存在名人，那么在迭代的过程必定会遇到名人,并且此时ans认识名人，不管ans此时是不是名人，所以此时令ans=名人。
在接下来的迭代中，由于名人不认识其他人，则必然不会发生ans值的变更。所以可知若存在名人，则ans必为名人。
得到ans后，我们需要判断ans是不是名人，这个判断过程很简单，就不细说了
链接：https://leetcode-cn.com/problems/find-the-celebrity/solution/javati-jie-jian-ji-yi-dong-by-polaris_co-yw9g/
     */
    public int findCelebrity(int n) {
        int ans = 0;
        for (int k = 0; k < n; k++) {
            if (knows(ans, k)) {
                ans = k;
            }
        }

        for (int k = 0; k < n; k++) {
            if (k != ans) {
                if (!knows(k, ans)) {
                    return -1;
                }
                if (knows(ans, k)) {
                    return -1;
                }
            }
        }
        return ans;
    }

    // 依次遍历，先遍历列(判断人人都认识名人)，再判断确定是否名人不认识别人
    public int findCelebrityOwn(int n) {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (!knows(i, j)) {
                    break;
                }
                if (i == n - 1) {
                    for (int k = 0; k < n; k++) {
                        if (knows(j, k) && j != k) {
                            break;
                        }
                        if (k == n - 1) {
                            return j;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean knows(int a, int b) {
        int[][] graph =
            // {
            //     {1, 1, 0},
            //     {0, 1, 0},
            //     {1, 1, 1}
            // };
            // {
            //     {1, 0, 1},
            //     {1, 1, 0},
            //     {0, 1, 1}
            // };
            {
                {1, 1},
                {0, 1}
            };
        // {
        //     {1, 1, 0},
        //     {0, 1, 1},
        //     {0, 1, 1}
        // };
        return graph[a][b] == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int celebrity = s.findCelebrity(3);
        int celebrity = s.findCelebrity(2);
        System.out.println(celebrity);
    }

}
