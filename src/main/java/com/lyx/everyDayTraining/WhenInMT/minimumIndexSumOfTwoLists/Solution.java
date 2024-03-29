package com.lyx.everyDayTraining.WhenInMT.minimumIndexSumOfTwoLists;

/*
599. 两个列表的最小索引总和

假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。

你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。

示例 1:

输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，
list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。

示例 2:

输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。

提示:

    1 <= list1.length, list2.length <= 1000
    1 <= list1[i].length, list2[i].length <= 30
    list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。
    list1 的所有字符串都是 唯一 的。
    list2 中的所有字符串都是 唯一 的。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lvyunxiao
 * @date 2022/3/14
 * @description
 */
public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> list2Map = new HashMap<>();
        Map<String, Integer> resMap = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            list2Map.put(list2[i], i);
        }
        for (int i = 0; i < list1.length; i++) {
            if (list2Map.containsKey(list1[i])) {
                resMap.put(list1[i], i + list2Map.get(list1[i]));
            }
        }
        int minIndex = Integer.MAX_VALUE;

        List<String> res = new ArrayList<>();
        Set<String> keySet = resMap.keySet();
        for (String k : keySet) {
            Integer count = resMap.get(k);
            if (count < minIndex) {
                res.clear();
                res.add(k);
                minIndex = count;
            } else if (minIndex == count) {
                res.add(k);
            }
        }

        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        // String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        String[] restaurant = s.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(restaurant));

    }
}
