package com.lyx.interview.kSumM;

/*
    给定随机数组data[],寻找制定k个数的和为m的所有组合

示例
int data[] = {1,2,3,4,5,6,8,9,10}
int k = 2;
int m = 7;

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/5/22
 * @description
 */
public class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    int sum = 0;
    int[] data;
    int n;

    public List<List<Integer>> getKSumM(int[] data, int k, int m) {
        Arrays.sort(data);
        this.data = data;
        n = data.length;
        trackback(k, m, 0);
        return ans;
    }

    // 回溯核心代码
    private void trackback(int k, int target, int idx) {
        // 当前k个数则返回，返回前判断sum是不是target
        if (cur.size() == k) {
            if (sum == target) {
                ans.add(new ArrayList<>(cur));
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            // 去重判断，类似三数之和
            if (i > idx && data[i] == data[i - 1]) {
                continue;
            }
            // 这里一定要剪枝不然超时
            if ((data[i] >= 0) && sum + data[i] > target) {
                return;
            }
            cur.add(data[i]);
            sum += data[i];
            // 注意下一个idx是i+1不是idx+1
            trackback(k, target, i + 1);
            cur.remove(cur.size() - 1);
            sum -= data[i];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int data[] = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        int k = 2;
        int m = 7;
        List<List<Integer>> kSumM = s.getKSumM(data, k, m);
        System.out.println(Arrays.deepToString(kSumM.toArray()));
    }

    /*
    class SolutionFourSum {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int sum = 0;
        int[] nums;
        int n;

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            this.nums = nums;
            n = nums.length;
            trackback(target, 0);
            return ans;
        }

        // 回溯核心代码
        private void trackback(int target, int idx) {
            //当前四个数则返回，返回前判断sum是不是target
            if (cur.size() == 4) {
                if (sum == target) {
                    ans.add(new ArrayList<>(cur));
                }
                return;
            }

            for (int i = idx; i < n; i++) {
                //去重判断，类似三数之和
                if (i > idx && nums[i] == nums[i - 1]) {
                    continue;
                }
                //这里一定要剪枝不然超时
                if ((nums[i] >= 0) && sum + nums[i] > target) {
                    return;
                }
                cur.add(nums[i]);
                sum += nums[i];
                // 注意下一个idx是i+1不是idx+1
                trackback(target, i + 1);
                cur.remove(cur.size() - 1);
                sum -= nums[i];
            }
        }
    }
     */


}
