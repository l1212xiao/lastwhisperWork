package com.lyx.geek.AlgoMei.search;

/**
 * @author lvyunxiao
 * @date 2021/7/14
 * @description
 */
public class SimpleBSearchDemo {

    public static void main(String[] args) {
        SimpleBSearchDemo s = new SimpleBSearchDemo();
        // int[] arr = {1, 2, 3, 4, 5};
        // int val = 2;
        // int index = s.bsearch(arr, val);
        // System.out.println(index);

        // int a = 2;
        // double gen = s.getGen(a);
        // System.out.println(gen);

        int a = 9;
        boolean perfectSquare = s.isPerfectSquare(a);
        System.out.println(perfectSquare);
    }

    public int bsearch(int[] a, int val) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == val) {
                return mid;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 求平方根，要求精确到小数点后 6 位
    public double getGen(int a) {
        if (a == 0) {
            return a;
        }
        double low = 0D;
        double high = a * 1.0D;
        double mid = low + ((high - low) / 2);
        while (Math.abs(a - (mid * mid)) > 0.000001D) {
            if (mid * mid == a) {
                return mid;
            } else if (mid * mid > a) {
                high = mid;
            } else {
                low = mid;
            }
            mid = low + ((high - low) / 2);
        }
        return mid;
    }

    // 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2, right = num / 2, x;
        while (left <= right) {
            x = left + (right - left) / 2;
            if (x * x == num) {
                return true;
            }
            if (x * x > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }

    // 搜索二维矩阵,一次二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // 搜索二维矩阵
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
