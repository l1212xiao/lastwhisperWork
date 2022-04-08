package com.lyx.everyDayTraining.notOnlyMicro.grayCode;

/*
89. 格雷编码
n 位格雷码序列 是一个由 2^n 个整数组成的序列，其中：

    每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
    第一个整数是 0
    一个整数在序列中出现 不超过一次
    每对 相邻 整数的二进制表示 恰好一位不同 ，且
    第一个 和 最后一个 整数的二进制表示 恰好一位不同

给你一个整数 n ，返回任一有效的 n 位格雷码序列 。

示例 1：

输入：n = 2
输出：[0,1,3,2]
解释：
[0,1,3,2] 的二进制表示是 [00,01,11,10] 。
- 00 和 01 有一位不同
- 01 和 11 有一位不同
- 11 和 10 有一位不同
- 10 和 00 有一位不同
[0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
- 00 和 10 有一位不同
- 10 和 11 有一位不同
- 11 和 01 有一位不同
- 01 和 00 有一位不同

示例 2：

输入：n = 1
输出：[0,1]

提示：
    1 <= n <= 16

 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/4/1
 * @description
 */
public class Solution {

    /*
    // 全量回溯，超时严重
    public List<Integer> grayCode(int n) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> bits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bits.add(1 << i);
        }
        dfs(ans, path, bits, n);
        System.out.println(Arrays.deepToString(ans.toArray()));
        if (!ans.isEmpty()) {
            return ans.get(0);
        } else {
            return new ArrayList<>();
        }
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, List<Integer> bits, int n) {
        Integer last = path.get(path.size() - 1);
        int total = 1 << n;
        List<Integer> oneBitChange = getOneBitChange(last, bits);
        if (path.size() == total) {
            if (oneBitChange.contains(0)) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (Integer cur : oneBitChange) {
            if (!path.contains(cur) && cur >= 0 && cur <= ((1 << n) - 1)) {
                path.add(cur);
                dfs(ans, path, bits, n);
                path.remove(path.size() - 1);
            }
        }
    }

    private List<Integer> getOneBitChange(int num, List<Integer> bits) {
        List<Integer> change = new ArrayList<>();
        for (Integer b : bits) {
            change.add(num ^ b);
        }
        return change;
    }

     */

    /*

    // 回溯 + 剪枝，lt上显示超时
    public List<Integer> grayCode(int n) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        return dfs(path, n);
    }

    // 回溯
    private List<Integer> dfs(List<Integer> path, int n) {
        Integer last = path.get(path.size() - 1);
        int total = 1 << n;
        List<Integer> oneBitChange = getOneBitChange(last, n);
        if (path.size() == total) {
            if (oneBitChange.contains(0)) {
                return new ArrayList<>(path);
            }
        }
        for (Integer cur : oneBitChange) {
            if (!path.contains(cur) && cur >= 0 && cur <= ((1 << n) - 1)) {
                path.add(cur);
                List<Integer> curList = dfs(path, n);
                if (!curList.isEmpty()) {
                    return new ArrayList<>(path);
                }
                path.remove(path.size() - 1);
            }
        }
        return new ArrayList<>();
    }

    // 对于num，获取只改变一位的数的列表
    private List<Integer> getOneBitChange(int num, int n) {
        List<Integer> bits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bits.add(1 << i);
        }
        List<Integer> change = new ArrayList<>();
        for (Integer b : bits) {
            change.add(num ^ b);
        }
        return change;
    }
     */


    /*
    方法一：对称生成
思路与算法
假设我们已经获取到 n−1 位的格雷码序列 Gn−1，我们只需要将 Gn−1 对称翻转，记作 Gn−1T。Gn−1 的首元素和 Gn−1T 的尾元素都是相同的，
反之亦然。如果我们给 Gn−1 的每个元素都加上 2^{n-1}，记作 (Gn−1T)′，则 Gn−1的首元素和 (Gn−1T)′′ 的尾元素只有一位不相同，反之亦然。
初始值 G0=[0]
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ans.size();
            for (int j = m - 1; j >= 0; j--) {
                ans.add(ans.get(j) | (1 << (i - 1)));
            }
        }
        return ans;
    }

    /*
    方法二：二进制数转格雷码
思路与算法
如果我们有一个二进制数序列，我们也可以将它直接转换成格雷码序列。假设 n 位二进制数为 b，对应的格雷码为 g，转换规则如下：
g(i)=b(i+1)⊕b(i), 0≤i<n
其中 ⊕是按位异或运算，g(i) 和 b(i) 分别表示 g 和 b 的第 i 位，且 0b(n)=0。
     */
    public List<Integer> grayCode2(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add((i >> 1) ^ i);
        }
        return ans;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        // int n = 2;
        // int n = 3;
        int n = 3;
        List<Integer> grayCode = s.grayCode(n);
        System.out.println(Arrays.toString(grayCode.toArray()));
    }

}
