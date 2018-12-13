package com.lyx.Array.MajorityElement;

/**
 * Created by lyx on 2018/5/25.
 */
public class Test {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {3, 2, 3};

        int i = solution.majorityElement(nums);

        System.out.println(i);
    }
}
