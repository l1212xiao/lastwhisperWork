package com.lyx.Triangle.pascalsTriangle;

import java.util.List;

/**
 * Created by lyx on 2018/5/3.
 */
public class Test {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        List<List<Integer>> lists = solution.generate(5);

        PrintLists(lists);
    }

    public static void PrintLists(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
