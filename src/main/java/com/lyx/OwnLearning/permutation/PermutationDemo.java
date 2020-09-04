package com.lyx.OwnLearning.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lvyunxiao
 * @date 2020/7/30
 * 实现字符串数组的全排列
 */
public class PermutationDemo {

    // 排列组合 O(n!)
    // strs里放着所有的字符串
    // 已经使用过的字符串的下标，在use里登记了，不要再使用了
    // 之前使用过的字符串，拼接成了-> path
    // 用all收集所有可能的拼接结果
    /**
     *
     * @param strs  源字符串数组
     * @param use   已使用的字符串
     * @param path  当前拼接的
     * @param all   所有可能性记录数组
     */
    public static void process(String[] strs, Set<Integer> use, String path, List<String> all) {
        if (use.size() == strs.length) {
            all.add(path);
        } else {
            for (int i = 0; i < strs.length; i++) {
                if (!use.contains(i)) {
                    use.add(i);
                    process(strs, use, path + strs[i], all);
                    use.remove(i);
                }
            }
        }
    }

    public static List<String> process(String[] strs) {
        HashSet<Integer> use = new HashSet<>();
        String path = "";
        ArrayList<String> all = new ArrayList<>();
        process(strs, use, path, all);
        return all;
    }

    public static void main(String[] args) {
        String[] strs = {"a", "b", "c"};
        // HashSet<Integer> use = new HashSet<>();
        // String path = "";
        // ArrayList<String> all = new ArrayList<>();
        // process(strs, use, path, all);
        List<String> all = process(strs);

        System.out.println("------------------------");
        for (String s : all) {
            System.out.print(s + " ");
        }
        // abc acb bac bca cab cba
        System.out.println("\n------------------------");
    }
}
