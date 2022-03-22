package com.lyx.training.codeFor.stage01;

/*
给定一个有序数据arr，代表坐落在X轴上的点
给定一个正数K，代表绳子的长度
返回绳子最多压中几个点？
即使绳子边缘处盖住点也算盖住
 */


/**
 * @author lvyunxiao
 * @date 2022/2/18
 * @description
 */
public class Code01_CordCoverMaxPoint {

    public static int maxPoint(int[] arr, int l) {
        int left = 0;
        int right = 0;

        int n = arr.length;
        int max = 0;
        while (left < n) {
            while (right < n && arr[right] - arr[left] <= l) {
                right++;
            }
            max = Math.max(max, right - (left++));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 11};
        int l = 4;
        int maxPoint = maxPoint(arr, l);
        System.out.println(maxPoint);
    }


}
