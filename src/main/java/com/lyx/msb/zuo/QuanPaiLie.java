package com.lyx.msb.zuo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/8/5
 */
// permutation
// 求字符串的子序列
public class QuanPaiLie {
    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, 0, ans, path);
        return ans;
    }

    // str固定，不变
    // index此时来到的位置, 要  or 不要
    // 如果index来到了str中的终止位置，把沿途路径所形成的答案，放入ans中
    // 之前做出的选择，就是path
    public static void process1(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process1(str, index + 1, ans, no);
        String yes = path + str[index];
        process1(str, index + 1, ans, yes);
    }

    public static void main(String[] args) {
        String s = "abcd";
        List<String> subs = subs(s);
        // subs.forEach(e -> System.out.println(e));
        subs.forEach(System.out::println);
    }
}
