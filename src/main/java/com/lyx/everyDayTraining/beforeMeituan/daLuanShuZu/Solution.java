package com.lyx.everyDayTraining.beforeMeituan.daLuanShuZu;

import java.util.Random;

/**
 * @author lvyunxiao
 * @date 2020/9/11
 * 384. 打乱数组
 * 打乱一个没有重复元素的数组。
 */
public class Solution {

    private int[] array;
    private int[] original;

    Random random = new Random();

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
        // return (int) (Math.random() * (max - min)) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    //
    // 作者：LeetCode
    // 链接：https://leetcode-cn.com/problems/shuffle-an-array/solution/da-luan-shu-zu-by-leetcode/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
