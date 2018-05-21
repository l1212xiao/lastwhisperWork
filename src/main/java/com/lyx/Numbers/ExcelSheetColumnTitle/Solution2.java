package com.lyx.Numbers.ExcelSheetColumnTitle;

/**
 * Created by lyx on 2018/5/21.
 */
public class Solution2 {
    public String convertToTitle(int n) {
        String result = "";
        while (n !=0) {
            result = (char) ((n - 1) % 26 + 'A') + result;
            n = (n - 1) / 26;
        }
        return result;
    }
}
