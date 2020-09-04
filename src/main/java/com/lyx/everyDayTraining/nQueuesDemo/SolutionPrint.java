package com.lyx.everyDayTraining.nQueuesDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/9/4
 * <p>
 * 51. N 皇后
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 链接：https://leetcode-cn.com/problems/n-queens
 */
public class SolutionPrint {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] record = new int[n];

        process(0, record, n, result);
        return result;
    }

    public void process(int i, int[] record, int n, List<List<String>> result) {
        if (i == n) {
            List<String> work = new ArrayList<>();
            for (int index : record) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (index == j) {
                        s.append("Q");
                    } else {
                        s.append(".");
                    }
                }
                work.add(s.toString());
            }
            result.add(work);
        }
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                process(i + 1, record, n, result);
            }
        }
    }

    public boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    // public int totalNQueens(int n) {
    //     if (n < 1) {
    //         return 0;
    //     }
    //     int[] record = new int[n];
    //     return process(0, record, n);
    // }
    //
    // private int process(int i, int[] record, int n) {
    //     if (i == n) {
    //         return 1;
    //     }
    //     int res = 0;
    //     for (int j = 0; j < n; j++) {
    //         if (isValid(record, i, j)) {
    //             record[i] = j;
    //             res += process(i + 1, record, n);
    //         }
    //     }
    //     return res;
    // }


    public static void main(String[] args) {
        SolutionPrint solution = new SolutionPrint();
        int n = 4;
        System.out.println(solution.solveNQueens(n));
    }

}
