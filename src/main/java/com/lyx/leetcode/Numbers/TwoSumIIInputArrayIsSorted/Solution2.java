package com.lyx.Numbers.TwoSumIIInputArrayIsSorted;

/**
 * Created by lyx on 2018/5/14.
 */
class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        int[] re = new int[2];
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum > target) high--;
            else if (sum < target) low++;
            else {
                re[0] = low + 1;
                re[1] = high + 1;
                break;
            }
        }
        return re;
    }
}
