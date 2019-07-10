package com.lyx.leetcode.Triangle.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyx on 2018/5/3.
 */
public class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(resultList.get(i - 1).get(j - 1) + resultList.get(i - 1).get(j));
                }
            }
            resultList.add(list);
            list = new ArrayList<Integer>();
        }
        return resultList;
    }
}
