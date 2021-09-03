package com.lyx.everyDayTraining.beforeMeituan.repeatNum;

import java.util.BitSet;
import java.util.Date;

/**
 * @author lvyunxiao
 * @date 2020/8/31
 * <p>
 * 有1亿个数字，其中有2个是重复的，快速找到它，时间和空间要最优
 * 通过计数排序联想到
 * 原理：把数字值直接映射到数组下标（时间最优），这里重复的数字只有两次，为了空间最优，就用bit来表示（只有0和1），1byte=8bit，一个byte可以存储8个数字的计数。
 * 所以建立数组 byte[] bucket=new byte[(最大值-最小值)/8+1];
 * <p>
 * https://blog.csdn.net/m0_37756306/article/details/105553284?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.edu_weight&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.edu_weight
 */
public class RepeatNumDemo {

    public static int getRepeatNum(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int value : arr) {
            if (value < min)
                min = value;
            if (value > max)
                max = value;
        }
        byte[] bucket = new byte[(max - min) / 8 + 1];
        for (int num : arr) {
            int j = (num - min) / 8;
            int k = (num - min) % 8;
            if (((bucket[j] >> k) & 1) > 0) {//重复了
                System.out.println("Number of repeats：" + num);
                return num;
            } else {
                bucket[j] |= (1 << k);
            }
        }
        return -1;
    }

    public static int getRepeatNum2(int[] arr) {
        BitSet bitSet = new BitSet();
        for (int num : arr) {
            if (bitSet.get(num)) {
                return num;
            } else {
                bitSet.set(num);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int[] arr = new int[1_0000_0000];//1亿长度
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        arr[9999_9999] = 2020;

        int repeatNum = getRepeatNum2(arr);
        System.out.println(repeatNum);

        long time2 = System.currentTimeMillis();
        System.out.println("millisecond:" + (time2 - time));
    }


}
