package com.lyx.geek.AlgoMei.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2021/8/19
 * @description ref : https://blog.csdn.net/qq_42894896/article/details/82182775
 */
public class TrainingDemo {

    /*
    31、和为n 连续正数序列
    题目：输入一个正数n，输出所有和为n 连续正数序列。
    例如输入15，由于 1+2+3+4+5=4+5+6=7+8=15，所以输出3 个连续序列1-5、4-6 和7-8。
     */
    public List<String> getSequence(int n) {
        List<String> result = new ArrayList<>();
        if (n < 3) {
            return result;
        }
        int maxLen = n - 1;
        for (int len = 2; len <= maxLen; len++) {
            for (int begin = 1; begin <= n - begin; begin++) {
                int end = begin + len - 1;
                if (((begin + end) * len / 2) == n) {
                    result.add(begin + "->" + end);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TrainingDemo s = new TrainingDemo();
        int n = 15;
        List<String> sequence = s.getSequence(n);
        System.out.println(Arrays.toString(sequence.toArray()));
    }

}
