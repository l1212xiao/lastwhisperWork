package com.lyx.interview.BaiXin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * from interviewee of 李小明 on 2022-09-27
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例：
 * 输入：nums = [1,2,3]
 * [1,2]  [2,1]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Premute {


    public List<List<Integer>> permute(int[] nums) {
        // 临时集合存放 X 个数字的全排列， X+1个数组 将最后一个数字插入到临时集合（遍历临时集合 插入到起点到终点的位置）
        List<List<Integer>> result = new ArrayList<>();
        for (int s : nums) {
            result = findResult(result, s);

        }
        return result;
    }

    /**
     * @param temp   当前可能的全排列组合
     * @param number 需要插入的新的数字
     * @return
     */
    private List<List<Integer>> findResult(List<List<Integer>> temp, int number) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(temp) || temp.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            item.add(number);
            result.add(item);
            return result;
        }

        for (List<Integer> list : temp) {
            // 元素和插入的数字组成集合 放到结果中
            result.addAll(findResultItems(list, number));
        }
        return result;
    }

    /**
     * 集合任意位置插入数字，返回所有可能的集合
     *
     * @param temp
     * @param number
     * @return
     */
    private List<List<Integer>> findResultItems(List<Integer> temp, int number) {
        List<List<Integer>> result = new ArrayList<>();
        int length = temp.size();
        for (int i = 0; i <= length; i++) {
            Object[] objects = temp.toArray();
            Integer[] dest = new Integer[objects.length];
            System.arraycopy(objects, 0, dest, 0, objects.length);
            List<Integer> t = new ArrayList<>(Arrays.asList(dest));
            t.add(i, number);
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        /*List<Integer> temp = new ArrayList<>(Arrays.asList(1, 2, 3));

        List<List<Integer>> resultItems = new Premute().findResultItems(temp, 4);

        System.out.println(resultItems);*/

        int[] original = new int[]{1, 2, 3};

        List<List<Integer>> permute = new Premute().permute(original);

        System.out.println(permute);
    }

}
