package com.lyx.everyDayTraining.beforeMeituan.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/9/9
 */
public class SolutionTraining {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n, k, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void dfs(int n, int k, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (k == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        if (idx < n) {
            // no choice
            dfs(n, k, ans, combine, idx + 1);

            // choice
            combine.add(idx + 1);
            dfs(n, k - 1, ans, combine, idx + 1);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        SolutionTraining s = new SolutionTraining();
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = s.combine(n, k);
        System.out.println(Arrays.toString(combine.toArray()));
    }

}
