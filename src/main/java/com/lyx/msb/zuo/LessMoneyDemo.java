package com.lyx.msb.zuo;

import java.util.PriorityQueue;

/**
 * @author lvyunxiao
 * @date 2020/8/3
 */
public class LessMoneyDemo {
    /**
     * 贪心算法的解题套路实战
     * 一块金 条切成两半，是需要花费和长度数值一样的铜板的。
     * 比如长度为20的金条，不管怎么切，都要花费20个铜板。一群人想整分整块金条，怎么分最省铜板?
     * 例如，给定数组{10,20,30}，代表一共三个人，整块金条长度为60，金条要分成10，20，30三 个部分。
     * 如果先把长度60的金条分成10和50，花费60;再把长度50的金条分成20和30.花费50;-共花费110铜板。
     * 但如果先把长度60的金条分成30和30，花费60;再把长度30金条分成10和20，花 费30;一共花费90铜板。
     * 输入一个数组，返回分割的最小代价。
     */
    public static int lessMoney2(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int money2 = lessMoney2(arr);
        System.out.println(money2);
    }
}
