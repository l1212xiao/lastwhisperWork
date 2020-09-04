package com.lyx.everyDayTraining.repeatedSubstringPattern;

/**
 * @author lvyunxiao
 * @date 2020/8/24
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution4 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        String s = "abab";
        Solution4 solution = new Solution4();
        boolean b = solution.repeatedSubstringPattern(s);
        System.out.println(b);
    }
}
