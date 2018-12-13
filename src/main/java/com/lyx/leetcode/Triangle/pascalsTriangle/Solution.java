package com.lyx.Triangle.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyx on 2018/5/3.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                list.add(1);
            }
            resultList.add(list);
            list = new ArrayList<Integer>();
        }

        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j <= i - 1; j++) {
                resultList.get(i).set(j, (resultList.get(i - 1).get(j - 1) + resultList.get(i - 1).get(j)));
            }
        }
        return resultList;
    }
}
