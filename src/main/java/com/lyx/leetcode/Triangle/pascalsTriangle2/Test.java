package com.lyx.Triangle.pascalsTriangle2;

import java.util.List;

/**
 * Created by lyx on 2018/5/3.
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> row = solution.getRow(3);
        PrintList(row);
    }

    public static void PrintList(List<Integer> row) {
        for (int x : row) {
            System.out.print(x + " ");
        }
    }
}
