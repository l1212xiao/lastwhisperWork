package com.lyx.geek.AlgoMei.dynamicProgramming;

/*
118. 杨辉三角
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。
示例 1:

输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
示例 2:

输入: numRows = 1
输出: [[1]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2021/8/10
 * @description
 */
public class YanghuiTriangle {

    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path;
        for (int row = 0; row < numRows; row++) {
            path = new ArrayList<>();
            int i = row;
            int j = 0;
            while (i >= 0) {
                path.add(dp[i][j]);
                i--;
                j++;
            }
            result.add(path);
        }
        return result;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) {
            return result;
        }
        //添加第一行元素
        List<Integer> num1Row = new ArrayList<>();
        num1Row.add(1);
        result.add(num1Row);
        //从第二行开始
        for (int i = 1; i < numRows; i++) {
            List<Integer> numRowList = new ArrayList<>();
            numRowList.add(1);
            List<Integer> numRowPreList = result.get(i - 1);
            for (int j = 1; j < numRowPreList.size(); j++) {
                numRowList.add(numRowPreList.get(j) + numRowPreList.get(j - 1));
            }
            numRowList.add(1);
            result.add(numRowList);
        }
        return result;
    }

    public static void main(String[] args) {
        YanghuiTriangle s = new YanghuiTriangle();
        List<List<Integer>> lists = s.generate2(5);
        lists.forEach(e -> System.out.println(Arrays.toString(e.toArray())));
    }


}
