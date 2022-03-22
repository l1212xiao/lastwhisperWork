package com.lyx.everyDayTraining.WhenInMT.pushDominoes;

/*
838. 推多米诺

n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。

给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：

    dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
    dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
    dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。

返回表示最终状态的字符串。

示例 1：

输入：dominoes = "RR.L"
输出："RR.L"
解释：第一张多米诺骨牌没有给第二张施加额外的力。

示例 2：

输入：dominoes = ".L.R...LR..L.."
输出："LL.RR.LLRRLL.."

 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/2/22
 * @description
 */
public class Solution {

    /*
    方法一：广度优先搜索
思路
当时间为 0 时，部分骨牌会受到一个初始的向左或向右的力而翻倒。过了 1 秒后，这些翻倒的骨牌会对其周围的骨牌施加一个力。具体表现为：
    向左翻倒的骨牌，如果它有直立的左边紧邻的骨牌，则会对该直立的骨牌施加一个向左的力。
    向右翻倒的骨牌，如果它有直立的右边紧邻的骨牌，则会对该直立的骨牌施加一个向右的力。
接下去需要分析这些 1 秒时受力的骨牌的状态。如果仅受到单侧的力，它们会倒向单侧；如果受到两个力，则会保持平衡。
再过 1 秒后，这些新翻倒的骨牌又会对其他直立的骨牌施加力，而不会对正在翻倒或已经翻倒的骨牌施加力。
这样的思路类似于广度优先搜索。我们用一个队列 q 模拟搜索的顺序；数组 time 记录骨牌翻倒或者确定不翻倒的时间，
翻倒的骨牌不会对正在翻倒或者已经翻倒的骨牌施加力；数组 force 记录骨牌受到的力，骨牌仅在受到单侧的力时会翻倒。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/push-dominoes/solution/tui-duo-mi-nuo-by-leetcode-solution-dwgm/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int[] time = new int[n];
        Arrays.fill(time, -1);
        List<Character>[] force = new List[n];
        for (int i = 0; i < n; i++) {
            force[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            char f = dominoes.charAt(i);
            if (f != '.') {
                queue.offer(i);
                time[i] = 0;
                force[i].add(f);
            }
        }

        char[] res = new char[n];
        Arrays.fill(res, '.');
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (force[i].size() == 1) {
                char f = force[i].get(0);
                res[i] = f;
                int ni = f == 'L' ? i - 1 : i + 1;
                if (ni >= 0 && ni < n) {
                    int t = time[i];
                    if (time[ni] == -1) {
                        queue.offer(ni);
                        time[ni] = t + 1;
                        force[ni].add(f);
                    } else if (time[ni] == t + 1) {
                        force[ni].add(f);
                    }
                }
            }
        }
        return new String(res);
    }

    /*
     BFS
推倒骨牌是一个行为传递的过程，可以使用 BFS 来进行模拟。
起始将所有不为 . 的骨牌以 (loc,time,dire) 三元组的形式进行入队，
三元组所代表的含义为「位置为 loc 的骨牌在 time 时刻受到一个方向为 dire 的力」，然后进行常规的 BFS 即可。
在受力（入队）时，我们尝试修改骨牌的状态，同时为了解决「一个骨牌同时受到左右推力时，维持站立状态不变」的问题，
我们需要在尝试修改骨牌状态后，额外记录下该骨牌的状态修改时间，如
果在同一时间内，一块骨牌受力两次（只能是来自左右两个方向的力），需要将该骨牌恢复成竖立状态。

作者：AC_OIer
链接：https://leetcode-cn.com/problems/push-dominoes/solution/gong-shui-san-xie-yi-ti-shuang-jie-bfs-y-z52w/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public String pushDominoes2(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = arr.length;
        int[] g = new int[n];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '.') {
                continue;
            }
            int dire = arr[i] == 'L' ? -1 : 1;
            queue.add(new int[]{i, 1, dire});
            g[i] = 1;
        }
        while (!queue.isEmpty()) {
            int[] info = queue.pollFirst();
            int loc = info[0], time = info[1], dire = info[2];
            int ne = loc + dire;
            if (arr[loc] == '.' || (ne < 0 || ne >= n)) {
                continue;
            }
            if (g[ne] == 0) { // 首次受力
                queue.addLast(new int[]{ne, time + 1, dire});
                g[ne] = time + 1;
                arr[ne] = dire == -1 ? 'L' : 'R';
            } else if (g[ne] == time + 1) { // 多次受力
                arr[ne] = '.';
            }
        }
        return String.valueOf(arr);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String dominoes = ".L.R...LR..L..";
        // String dominoes = "..R..";
        String pushDominoes = s.pushDominoes2(dominoes);
        System.out.println(pushDominoes);
    }
}
