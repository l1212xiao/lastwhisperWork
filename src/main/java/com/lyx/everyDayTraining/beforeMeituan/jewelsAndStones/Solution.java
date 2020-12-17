package com.lyx.everyDayTraining.beforeMeituan.jewelsAndStones;

/*
771. 宝石与石头
 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

示例 1:

输入: J = "aA", S = "aAAbbbb"
输出: 3
示例 2:

输入: J = "z", S = "ZZ"
输出: 0
注意:

S 和 J 最多含有50个字母。
 J 中的字符不重复。
 */


import java.util.HashSet;
import java.util.Set;

/**
 * @author lvyunxiao
 * @date 2020/10/2
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                ans++;
            }
        }
        return ans;
    }

    public int numJewelsInStones2(String J, String S) {
        long xor = 0;
        for (int i = 0; i < J.length(); i++) {
            xor |= 1L << (J.charAt(i) - 'A');
        }
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            if ((xor & (1L << (S.charAt(i) - 'A'))) != 0) {
                res++;
            }
        }
        return res;
    }

    // 作者：sdwwld
    // 链接：https://leetcode-cn.com/problems/jewels-and-stones/solution/5chong-fang-shi-jie-jue-qi-zhong-wei-yun-suan-ji-b/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Solution s = new Solution();
        String J = "aabbCSSSSoooo";
        String S = "aabbCufyguhijtyuh0oooo";
        int i = s.numJewelsInStones2(J, S);
        System.out.println(i);
    }
}
