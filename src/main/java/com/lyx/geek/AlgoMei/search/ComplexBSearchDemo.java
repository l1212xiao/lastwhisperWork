package com.lyx.geek.AlgoMei.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lvyunxiao
 * @date 2021/7/15
 * @description ref:https://time.geekbang.org/column/article/42733
 */
public class ComplexBSearchDemo {

    @Test
    public void testBsearch() {
        int[] a = {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};

        ComplexBSearchDemo c = new ComplexBSearchDemo();
        int bsearch1 = c.bsearch1(a, 8);
        Assert.assertEquals(bsearch1, 5);

        int bsearch2 = c.bsearch2(a, 8);
        Assert.assertEquals(bsearch2, 7);
    }

    // 变体一：查找第一个值等于给定值的元素
    public int bsearch1(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                // a[mid]等于要查找的值时，我们就需要确认一下这个 a[mid]是不是第一个值等于给定值的元素
                if ((mid == 0) || a[mid - 1] != value) {
                    return mid;
                } else {
                    // 如果 a[mid]前面的一个元素 a[mid-1]也等于 value,要找的元素肯定出现在[low, mid-1]之间
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // 变体二：查找最后一个值等于给定值的元素
    public int bsearch2(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || a[mid + 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // 变体三：查找第一个大于等于给定值的元素
    public int bsearch3(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 变体四：查找最后一个小于等于给定值的元素
    public int bsearch4(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || a[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }



}
