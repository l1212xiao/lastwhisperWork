package com.lyx.leetcode.Numbers.ExcelSheetColumnTitle;

import java.util.ArrayList;

/**
 * Created by lyx on 2018/5/21.
 * 168. Excel Sheet Column Title
 */
public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return null;

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(0, (n - 1) % 26);

        while ((n - 1) / 26 != 0) {
            n = (n - 1) / 26;
            list.add(0, (n - 1) % 26);
        }

        StringBuffer sb = new StringBuffer();
        int a = 'A';
        for (int c : list) {
            char title = (char) (c + a);
            sb.append(title);
        }
        return sb.toString();

    }
}
